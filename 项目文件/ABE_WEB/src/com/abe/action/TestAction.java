package com.abe.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.abe.entity.Users;
import com.abe.service.iBaseService;
import com.abe.service.hx.iChatgroupService;
import com.abe.service.hx.iUsersService;
import com.abe.tools.MachineCode;


public class TestAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iChatgroupService groupSer;
	private iUsersService userSer;
	private Logger logger=Logger.getLogger(TestAction.class);
	
	
	public iUsersService getUserSer() {
		return userSer;
	}
	public void setUserSer(iUsersService userSer) {
		this.userSer = userSer;
	}
	public iChatgroupService getGroupSer() {
		return groupSer;
	}
	public void setGroupSer(iChatgroupService groupSer) {
		this.groupSer = groupSer;
	}
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	//-------------------------------------------------------------------
	
	public String test() {
		getRequest().setAttribute("AAA", "这是AAA");
		logger.debug("---------public String test() {--------");
		return SUCCESS;
	}
	
	public String test2() {
		System.out.println("测试能否查询数据库");
		List<Users> users=ser.find("from Users", null);
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getUNum()+" "+users.get(i).getUPass());
		}
		Users users2=(Users) ser.get(Users.class, "123213141");
		logger.debug(users2.getUName());
		//测试修改
		users2.setUName("测试修改");
		ser.update(users2);
		//测试添加
		
		//测试删除
		return SUCCESS;
	}
	
	/**
	 * 模拟APP以base64传输图片到web
	 * @return
	 */
	public String test3() {
		logger.debug("模拟APP以base64传输图片到web");
		List<Users> users=ser.find("from Users", null);
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getUNum()+" "+users.get(i).getUPass());
		}
		Users users2=(Users) ser.get(Users.class, "qwe");
		logger.debug(users2==null);
		
		return SUCCESS;
	}
	
	
	public String mc() throws Exception {
		String ip=MachineCode.getIpAddr(getRequest());
//		String mac=MachineCode.getMACAddress(ip);
		logger.debug(ip);
//		logger.debug(mac);
		return null;
	}
	
	public String chinese() throws IOException {
		String data="测试中文乱码";
		getPrintWriter().print(data);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	
	
	public String createGroupHx() {
		HashMap<String, Object> req=new HashMap<String, Object>();
		req.put("groupname","hello world");
		req.put("desc","欢迎各位对家务感兴趣的人加入");
		req.put("public",true);
		req.put("maxusers",200);
		req.put("approval",true);
		req.put("owner","271634032221266");
		JSONObject json=ser.objToJson(req);
		String token=userSer.getToken();
		String str=groupSer.createChatgroup(json.toString(), token);
		try {
			getPrintWriter().print(str);
			getPrintWriter().flush();
			getPrintWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
