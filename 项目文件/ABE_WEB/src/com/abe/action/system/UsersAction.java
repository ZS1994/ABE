package com.abe.action.system;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.PowerRole;
import com.abe.entity.Users;
import com.abe.service.iBaseService;
import com.abe.service.hx.iUsersService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

/**
 * 张顺 2016-12-12
 * 用户管理,web端对所有用户的管理
 * @author it023
 */
public class UsersAction extends BaseAction implements iBaseAction {
    
	
	
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iUsersService userSer;
	private Page page;
	private String result="users";
	private Users user;
	private List<Users> users; 
	private String cz;
	private String id;
	private Logger logger=Logger.getLogger(UsersAction.class);
	
	//-----------------------------------------------------
	public iBaseService getSer() {
		return ser;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public iUsersService getUserSer() {
		return userSer;
	}
	public void setUserSer(iUsersService userSer) {
		this.userSer = userSer;
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
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	//-----------------------------------------------------
	
	
	
	@Override
	public void clearOptions() {
		cz=null;
		id=null;
		user=null;
		users=null;
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
			user=(Users) ser.get(Users.class, id);
			if (user!=null) {
				ser.delete(user);
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
		if (page==null) {
			page=new Page(1, 0, 10);
		}
		StringBuffer hql=new StringBuffer("from Users where 1=1 ");
		if (id!=null) {
			hql.append("and UId like '%"+id+"%'" );
		}
		hql.append("order by UCreateTime desc ");
		users=ser.query(hql.toString(), null, hql.toString(), page);
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getRId()!=null) {
				PowerRole role=(PowerRole) ser.get(PowerRole.class, users.get(i).getRId());
				users.get(i).setRole(role);
			}
		}
		return result;
	}
	@Override
	public String gotoQuery() {
		clearSpace();
		clearOptions();
		if (page!=null) {
			page.setPageOn(1);
		}else {
			page=new Page(1, 0, 10);
		}
		String hql="from Users order by UCreateTime desc";
		users=ser.query(hql, null, hql, page);
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getRId()!=null) {
				PowerRole role=(PowerRole) ser.get(PowerRole.class, users.get(i).getRId());
				users.get(i).setRole(role);
			}
		}
		return result;
	}
	@Override
	public String update() {
		clearSpace();
		if (user!=null) {
			Users utmp=(Users) ser.get(Users.class, user.getUId());
			user.setUType(utmp.getUType());
			user.setUCreateTime(utmp.getUCreateTime());
			user.setUPhotoPath(utmp.getUPhotoPath());
			user.setUNote(utmp.getUNote());
			ser.update(user);
		}
		return gotoQuery();
	}

	/*张顺 2016-12-12*/
	@Override
	public String add() {
		clearSpace();
		if (user!=null) {
			user.setUId(NameOfDate.getNum());
			user.setUCreateTime(new Timestamp(new Date().getTime()));
			ser.save(user);
			//在环信系统中注册
			String token=userSer.getToken(iUsersService.ACCESS_TOKEN);
			String result=userSer.addUser(user.getUId(), user.getUPass(), token);
			logger.debug("环信注册返回结果："+result);
		}
		return gotoQuery();
	}
	
	
	

}
