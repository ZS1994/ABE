package com.abe.action.system;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts2.components.UIBean;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.PowerPermission;
import com.abe.entity.PowerRole;
import com.abe.entity.PowerRolePermission;
import com.abe.entity.Users;
import com.abe.entity.other.UiTree;
import com.abe.service.iBaseService;
import com.abe.service.hx.iUsersService;
import com.abe.service.system.iRoleService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

/**
 * 张顺 2016-12-12
 * 角色管理
 * @author it023
 */
public class RoleAction extends BaseAction implements iBaseAction {
    
	
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iRoleService roleSer;
	private Page page;
	private String result="role";
	private String resultTree="roleTree";
	private PowerRole role;
	private List<PowerRole> roles; 
	private String cz;
	private String id;
	private Logger logger=Logger.getLogger(RoleAction.class);
	
	//-----------------------------------------------------
	public iBaseService getSer() {
		return ser;
	}
	public iRoleService getRoleSer() {
		return roleSer;
	}
	public void setRoleSer(iRoleService roleSer) {
		this.roleSer = roleSer;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public PowerRole getRole() {
		return role;
	}
	public void setRole(PowerRole role) {
		this.role = role;
	}
	public List<PowerRole> getRoles() {
		return roles;
	}
	public void setRoles(List<PowerRole> roles) {
		this.roles = roles;
	}
	//-----------------------------------------------------
	
	
	
	@Override
	public void clearOptions() {
		cz=null;
		id=null;
		role=null;
		roles=null;
		if (page==null) {
			page=new Page(1, 0, 10);
		}else {
			page.setPageOn(1);
		}
	}

	@Override
	public void clearSpace() {
		cz=cz!=null?cz.trim():null;
		id=id!=null?id.trim():null;
	}

	@Override
	public String delete() {
		clearSpace();
		if (id!=null) {
			role=(PowerRole) ser.get(PowerRole.class, id);
			if (role!=null) {
				ser.delete(role);
				//删关系
				List<PowerRolePermission> list=ser.find("from PowerRolePermission where RId=?", new String[]{role.getRId()});
				for (int i = 0; i < list.size(); i++) {
					ser.delete(list.get(i));
				}
				//下级角色自动上升一级
				List<PowerRole> lists=ser.find("from PowerRole where RParentIds like ?", new String[]{"%,"+role.getRId()});
				for (int i = 0; i < lists.size(); i++) {
					lists.get(i).setRParentIds(lists.get(i).getRParentIds().replace(","+role.getRId(),""));
					ser.update(lists.get(i));
				}
				//给时间轴系统传参
				getRequest().setAttribute("obj", role);
			}
		}
		return gotoQuery();
	}


	@Override
	public String queryOfFenYe() {
		clearSpace();
		if (cz!=null && cz.equals("yes")) {
			clearOptions();
		}
		StringBuffer hql=new StringBuffer("from PowerRole where 1=1 ");
		if (id!=null) {
			hql.append("and RId like '%"+id+"%'" );
		}
		hql.append("order by RCreateTime desc ");
		roles=ser.query(hql.toString(), null, hql.toString(), page);
		//带上前端显示所需信息
		for (int i = 0; i < roles.size(); i++) {
			Users u=(Users) ser.get(Users.class, roles.get(i).getUId());
			roles.get(i).setUser(u);
		}
		return result;
	}
	@Override
	public String gotoQuery() {
		clearOptions();
		String hql="from PowerRole order by RCreateTime desc";
		roles=ser.query(hql, null, hql, page);
		//带上前端显示所需信息
		for (int i = 0; i < roles.size(); i++) {
			Users u=(Users) ser.get(Users.class, roles.get(i).getUId());
			roles.get(i).setUser(u);
		}
		return result;
	}
	
	/**
	 * 张顺 2016-12-26
	 * 修改角色（权限组）
	 */
	@Override
	public String update() {
		clearSpace();
		String persJson=ser.clearSpace(getRequest(), "pers_json");
		if (role!=null && persJson!=null) {
			PowerRole role2=(PowerRole) ser.get(PowerRole.class, role.getRId());
			role2.setRName(role.getRName());
			role2.setRDesc(role.getRDesc());
			ser.update(role2);
			List<PowerRolePermission> rel1=ser.find("from PowerRolePermission where RId=?", new String[]{role.getRId()});
			JSONArray array=JSONArray.fromObject(persJson);
			List<PowerRolePermission> rps1=new ArrayList<PowerRolePermission>();//新增权限
			List<PowerRolePermission> rps2=new ArrayList<PowerRolePermission>();//删除权限
			//找到新增权限
			for (int i = 0; i < array.size(); i++) {
				boolean isNew=true;//是否新增的标志
				for (int j = 0; j < rel1.size(); j++) {
					if (rel1.get(j).getPId().equals(array.getString(i))) {
						isNew=false;
						break;
					}
				}
				if (isNew) {
					PowerRolePermission rp=new PowerRolePermission(NameOfDate.getNum(), role.getRId(), array.getString(i));
					rps1.add(rp);
				}
			}
			//找到删除权限
			for (int i = 0; i < rel1.size(); i++) {
				boolean isDel=true;//是否删除的标志
				for (int j = 0; j < array.size(); j++) {
					if (rel1.get(i).getPId().equals(array.getString(j))) {
						isDel=false;
						break;
					}
				}
				if (isDel) {
					rps2.add(rel1.get(i));
				}
			}
			//新增新增的权限，删除删除的权限
			for (int i = 0; i < rps1.size(); i++) {
				ser.save(rps1.get(i));
			}
			for (int i = 0; i < rps2.size(); i++) {
				ser.delete(rps2.get(i));
			}
			//找到所有的下级角色
			roles=ser.find("from PowerRole where RParentIds like ?", new String[]{role2.getRParentIds()+","+role2.getRId()+"%"});
			//将每个下级角色移除删除权限列表中得权限
			for (int i = 0; i < roles.size(); i++) {
				rel1=ser.find("from PowerRolePermission where RId=?", new String[]{roles.get(i).getRId()});
				for (int j = 0; j < rel1.size(); j++) {
					for (int j2 = 0; j2 < rps2.size(); j2++) {
						if (rel1.get(j).getPId().equals(rps2.get(j2).getPId())) {
							ser.delete(rel1.get(j));
							break;
						}
					}
				}
			}
			getRequest().setAttribute("obj", role2);
		}
		return gotoQuery();
	}

	@Override
	public String add() {
		clearSpace();
		Users user=(Users) getSession().getAttribute("user");
		String persJson=ser.clearSpace(getRequest(), "pers_json");
		if (role!=null && persJson!=null && user!=null) {
			role.setRId(NameOfDate.getNum());
			role.setRCreateTime(new Timestamp(new Date().getTime()));
			role.setUId(user.getUId());
			ser.save(role);
			JSONArray array=JSONArray.fromObject(persJson);
			for (int i = 0; i < array.size(); i++) {
				PowerRolePermission rp=new PowerRolePermission(NameOfDate.getNum(), role.getRId(), array.getString(i));
				ser.save(rp);
			}
			getRequest().setAttribute("obj", role);
		}
		return gotoQuery();
	}
	
	/*以下是ajax访问的方法，用于异步显示角色树*/
	public String queryRoles() {
		clearSpace();
		List<UiTree> list=new ArrayList<UiTree>();
		String firstId=ser.clearSpace(getRequest(), "firstId");//需要显示的树的起点id
		if (firstId!=null && id==null) {
			id=firstId;
		}
		if (id==null) {
			HashMap<String, String> map=new HashMap<String, String>();
			map.put("next_ids", "0");
			UiTree tree=new UiTree("0", "选择这个代表无父id，即自己就是最高角色","icon-role","closed", false, map, null);
			list.add(tree);
		}else {
			if (id.equals("0")) {
				roles=ser.find("from PowerRole where RParentIds='0'", null);
			}else {
				roles=ser.find("from PowerRole where RParentIds like ?", new String[]{"%,"+id});
			}
			for (int i = 0; i < roles.size(); i++) {
				HashMap<String, String> map=new HashMap<String, String>();
				map.put("next_ids", roles.get(i).getRParentIds()+","+roles.get(i).getRId());
				UiTree tree=new UiTree(roles.get(i).getRId(), roles.get(i).getRName(),"icon-role", "closed", false, map, null);
				list.add(tree);
			}
		}
		sendJsonArry(list, ser);
		clearOptions();
		return null;
	}
	//获取权限信息
	public String getPers() {
		clearSpace();
		List<UiTree> list=new ArrayList<UiTree>();
		HashMap<String, String> map=new HashMap<String, String>();
		List<PowerPermission> pers=null;
		if (id==null || (id!=null && id.equals("0"))) {
			pers=roleSer.queryPers(null);
		}else {
			pers=roleSer.queryPers(id);
		}
		for (int i = 0; i < pers.size(); i++) {
			UiTree tree=new UiTree(pers.get(i).getPId()+"", pers.get(i).getPName(), "icon-permission","open", false, map, null);
			list.add(tree);
		}
		sendJsonArry(list, ser);
		clearOptions();
		return null;
	}
	//获取可修改的权限信息
	public String getPersFromUpdate() {
		clearSpace();
		List<UiTree> list=new ArrayList<UiTree>();
		HashMap<String, String> map=new HashMap<String, String>();
		List<PowerPermission> pers=null;
		if (id!=null){
			role=(PowerRole) ser.get(PowerRole.class, id);
			String ids[]=role.getRParentIds().split(",");
			pers=roleSer.queryPers(ids[ids.length-1]);
		}
		for (int i = 0; i < pers.size(); i++) {
			List<PowerPermission> list2=roleSer.queryPers(id);
			UiTree tree=new UiTree(pers.get(i).getPId()+"", pers.get(i).getPName(), "icon-permission","open", false, map, null);
			for (int j = 0; j < list2.size(); j++) {
				if (list2.get(j).getPId().equals(pers.get(i).getPId())) {
					tree.setChecked(true);
				}
			}
			list.add(tree);
		}
		sendJsonArry(list, ser);
		clearOptions();
		return null;
	}
}
