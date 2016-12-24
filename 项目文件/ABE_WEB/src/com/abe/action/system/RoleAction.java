package com.abe.action.system;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.struts2.components.UIBean;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.PowerPermission;
import com.abe.entity.PowerRole;
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
		return result;
	}
	@Override
	public String gotoQuery() {
		clearOptions();
		String hql="from PowerRole order by RCreateTime desc";
		roles=ser.query(hql, null, hql, page);
		return result;
	}
	@Override
	public String update() {
		clearSpace();
		if (role!=null) {
			
			
			getRequest().setAttribute("obj", role);
		}
		return gotoQuery();
	}

	@Override
	public String add() {
		clearSpace();
		if (role!=null) {
			role.setRId(NameOfDate.getNum());
			
			
			
			ser.save(role);
			getRequest().setAttribute("obj", role);
		}
		return gotoQuery();
	}
	
	/*以下是ajax访问的方法，用于异步显示角色树*/
	public String queryRoles() {
		logger.debug("----------queryRoles-------------"+id);
		clearSpace();
		List<UiTree> list=new ArrayList<UiTree>();
		HashMap<String, String> map=new HashMap<String, String>();
		if (id==null) {
			UiTree tree=new UiTree("0", "选择这个代表无父id，即自己就是最高角色", "closed", false, map, null);
			list.add(tree);
		}else {
			if (id.equals("0")) {
				roles=ser.find("from PowerRole where RParentIds='0'", null);
			}else {
				roles=ser.find("from PowerRole where RParentIds like ?", new String[]{"%,"+id});
			}
			for (int i = 0; i < roles.size(); i++) {
				map.put("path", "/web/role!queryOfFenYe?cz=no&id="+roles.get(i).getRId());
				UiTree tree=new UiTree(roles.get(i).getRId(), roles.get(i).getRName(), "closed", false, map, null);
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
			UiTree tree=new UiTree(pers.get(i).getPId()+"", pers.get(i).getPName(), "open", false, map, null);
			list.add(tree);
		}
		sendJsonArry(list, ser);
		return null;
	}
	
}
