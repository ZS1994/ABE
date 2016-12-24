package com.abe.action.system;

import java.io.IOException;
import java.sql.Timestamp;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.abe.action.BaseAction;
import com.abe.action.SignAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Users;
import com.abe.entity.other.RespCommon;
import com.abe.entity.other.RespUpdateUser;
import com.abe.entity.other.RespUploadPhoto;
import com.abe.service.iBaseService;
import com.abe.service.iSignService;

public class OneAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iSignService signSer;
	private Users user;
	private String result="index";
	private Logger logger=Logger.getLogger(OneAction.class);
	
	
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iSignService getSignSer() {
		return signSer;
	}
	public void setSignSer(iSignService signSer) {
		this.signSer = signSer;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	 /**
     * APP端查看个人信息
     * @return
     * @author 卢江林
    * @throws IOException 
     */
	public String getUsersInfor() throws IOException{
		logger.debug("-------进入个人信息中信getUsersInfor--------");
		String UId=getRequest().getParameter("UId");
		RespUpdateUser userInfor = signSer.queryUsers(UId);
		JSONObject jsonObject = ser.objToJson(userInfor, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	/**
	 * APP端修改个人信息
	 * @return
	 */
	public String updateUserFromApp1() throws IOException{
		logger.debug("-------进入updateUsersFromApp--------");
		String UNum=getRequest().getParameter("UNum");
		RespUpdateUser resp = signSer.updateUser1(UNum);
		sendToApp(resp, ser);
		return null;
	}
	public String updateUserFromApp2() throws IOException{
		logger.debug("-------进入updateUsersFromApp--------");
		String UName = ser.clearSpace(getRequest(), "UName");
		String UId = ser.clearSpace(getRequest(), "UId");
		RespUpdateUser resp = signSer.updateUser2(UId,UName);
		sendToApp(resp, ser);
		return null;
	}
	
	/**
	 * app端修改密码
	 * @return
	 */
	public String updatePass() {
		String uid=ser.clearSpace(getRequest(), "UId");
		String oldPass=ser.clearSpace(getRequest(), "oldPass");
		String newPass=ser.clearSpace(getRequest(), "newPass");
		RespCommon resp=signSer.updatePass(uid, oldPass, newPass);
		try {
			sendToApp(resp, ser);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 上传图片
	 * @return
	 * @throws IOException 
	 */
	public String uploadPhoto() throws IOException {
		String uid=getRequest().getParameter("UId");
		String photo=getRequest().getParameter("UPhoto");
		String format=getRequest().getParameter("format");
		//项目物理路径
		String abePath=getRequest().getRealPath("/");
		RespUploadPhoto respSignUp=signSer.uploadPhoto(uid, photo, format, abePath);
		sendToApp(respSignUp, ser);
		return null;
	}
	
	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSpace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gotoQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

}
