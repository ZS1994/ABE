package com.abe.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.abe.entity.Code;
import com.abe.entity.InfoParents;
import com.abe.entity.InfoTeacher;
import com.abe.entity.Licence;
import com.abe.entity.School;
import com.abe.entity.SchoolClass;
import com.abe.entity.SchoolGrade;
import com.abe.entity.SchoolSection;
import com.abe.entity.Timetables;
import com.abe.entity.Users;
import com.abe.entity.other.RespCommon;
import com.abe.entity.other.RespSignIn;
import com.abe.entity.other.RespUpdateUser;
import com.abe.entity.other.RespUploadPhoto;
import com.abe.service.iSignService;
import com.abe.service.home.impl.ParentServiceImpl;
import com.abe.service.hx.iUsersService;
import com.abe.tools.Base64;
import com.abe.tools.Constant;
import com.abe.tools.HttpClientHelper;
import com.abe.tools.MachineCode;
import com.abe.tools.NameOfDate;
import com.abe.tools.TokenProccessor;

public class SignServiceImpl extends ParentServiceImpl implements iSignService{
	
	private Logger logger=Logger.getLogger(SignServiceImpl.class);
	private iUsersService usersSer;
	
	
	public iUsersService getUsersSer() {
		return usersSer;
	}
	public void setUsersSer(iUsersService usersSer) {
		this.usersSer = usersSer;
	}


	@Override
	public String[] signIn(HttpSession session,String hint,Users user) {
		final String HINT_NO_USER="用户不存在";//用户不存在
		final String HINT_NO_PASS="密码错误";//密码错误
		final String HINT_ERROR_TYPE="该用户类型不是教职工";
		final String HINT_NO_INFO="该用户缺少档案信息";
		final String HINT_ERROR_INFO="该用户档案错误";
		final String HINT_ERROR_OTHER="其他错误，导致未找到该用户的学校";
		final String result="index";
		final String result_fail="login";
		List list=find("from Users where UNum=?", new Object[]{user.getUNum()});
		Users u=null;
		if (list.size()>0) {
			u=(Users) list.get(0);
		}
		if (u==null) {
			hint=HINT_NO_USER;
			return new String[]{hint,result_fail};
		}else {
			if (!u.getUPass().equals(user.getUPass())) {
				hint=HINT_NO_PASS;
				return new String[]{hint,result_fail};
			}else {
				if (u.getUType()!=null && u.getUType().equals("2")) {
					if (u.getTrpId()!=null) {
						InfoTeacher infoTea=(InfoTeacher) get(InfoTeacher.class, u.getTrpId());
						if (infoTea!=null) {
							//2017-1-12，张顺，获取学校信息并保存
							/*从三个方面来找教职工的学校：
							 * 		1、如果是班级的班主任，那么该班级所属的学校即是。
							 * 		2、如果是课程表的课程的授课老师，那么该课程所属的课程表，该课程表所属的班级，该班级所属的学校即是。
							 * 		3、如果是部门的一员，那么该部门所属的学校即是。
							 * */
							boolean isFind=false;//是否已经找到的标志
							School school=null;//先声明,待用
							List<SchoolClass> scs=find("from SchoolClass where itId=?", new String[]{infoTea.getItId()});
							if (isFind==false && scs.size()>0 && scs.get(0).getSgId()!=null) {
								SchoolGrade sg=(SchoolGrade) get(SchoolGrade.class, scs.get(0).getSgId());
								if (sg!=null && sg.getSId()!=null) {
									school=(School) get(School.class, sg.getSId());
									if (school!=null) 
										isFind=true;
								}
							}
							List<Timetables> tts=find("from Timetables where itId=?", new String[]{infoTea.getItId()});
							if (isFind==false && tts.size()>0 && tts.get(0).getScId()!=null) {
								SchoolClass sc=(SchoolClass) get(SchoolClass.class, tts.get(0).getScId());
								if (sc!=null && sc.getSgId()!=null) {
									SchoolGrade sg=(SchoolGrade) get(SchoolGrade.class, sc.getSgId());
									if (sg!=null && sg.getSId()!=null) {
										school=(School) get(School.class, sg.getSId());
										if (school!=null) 
											isFind=true;
									}
								}
							}
							if (isFind==false && infoTea.getSsId()!=null) {
								SchoolSection sss=(SchoolSection) get(SchoolSection.class, infoTea.getSsId());
								if (sss!=null && sss.getSId()!=null) {
									school=(School) get(School.class, sss.getSId());
									if (school!=null) 
										isFind=true;
								}
							}
							if (school!=null) {
								u.setSchool(school);
								session.setAttribute("user", u);
								return new String[]{hint,result};
							}else {
								hint=HINT_ERROR_OTHER;
								return new String[]{hint,result_fail};
							}
						}else {
							hint=HINT_ERROR_INFO;
							return new String[]{hint,result_fail};
						}
					}else {
						hint=HINT_NO_INFO;
						return new String[]{hint,result_fail};
					}
				}else {
					hint=HINT_ERROR_TYPE;
					return new String[]{hint,result_fail};
				}
			}
		}
	}
	
	
	@Override
	@Deprecated
	public RespSignIn signInFromApp(String uNum, String uPass) {
		List list=find("from Users where UNum=?", new Object[]{uNum});
		Users u=null;
		if (list.size()>0) {
			u=(Users) list.get(0);
		}
		RespSignIn respSignIn=new RespSignIn();
		if (u==null) {
			respSignIn.setResult("002");
		}else {
			if (!u.getUPass().equals(uPass)) {
				respSignIn.setResult("003");
			}else {
				respSignIn.setResult("001");
				u.setUPass(null);//去掉密码信息
				respSignIn.setData(u);
			}
		}
		return respSignIn;
	}

	
	@Override
	public RespCommon signInFromApp(String uNum, String uPass,
			HttpServletRequest request) throws Exception {
		List list=find("from Users where UNum=?", new Object[]{uNum});
		Users u=null;
		if (list.size()>0) {
			u=(Users) list.get(0);
		}
		RespCommon respSignIn=new RespCommon();
		if (u==null) {
			respSignIn.setResult("002");
		}else {
			if (!u.getUPass().equals(uPass)) {
				respSignIn.setResult("003");
			}else {
				respSignIn.setResult("001");
				u.setUPass(null);//去掉密码信息
				String ip=MachineCode.getIpAdd(request);
				String licence=TokenProccessor.getInstance().makeToken();
				Date dateStart=new Date();
				Date dateEnd=getEndDate(dateStart);
				Licence licencetmp=(Licence) get(Licence.class, u.getUId());
				if (licencetmp==null) {
					Licence licenceObj=new Licence(u.getUId(),licence,ip, new Timestamp(dateStart.getTime()), new Timestamp(dateEnd.getTime()));
					save(licenceObj);
				}else {
					licencetmp.setLLicence(licence);
					licencetmp.setLIp(ip);
					licencetmp.setLDateStart(new Timestamp(dateStart.getTime()));
					licencetmp.setLDateEnd(new Timestamp(dateEnd.getTime()));
					update(licencetmp);
				}
				HashMap map=new HashMap();
				map.put("user", u);
				map.put("licence", licence);
				respSignIn.setData(map);
			}
		}
		return respSignIn;
	}

	
	public Date getEndDate(Date date) {
		Date datetmp=null;
		if (date==null) {
			datetmp=new Date();
		}else {
			datetmp=date;
		}
		Calendar calendar=new GregorianCalendar(); 
		calendar.setTime(datetmp);
		calendar.add(Calendar.HOUR, 1);
		return calendar.getTime();
	}
	
	
	@Override
	public RespUploadPhoto uploadPhoto(String UId, String photo,String format,String abePath) {
		//清空格
		if (UId!=null) {
			UId=UId.trim();
		}
		if (photo!=null) {
			photo=photo.trim();
		}
		if (format!=null) {
			format=format.trim();
		}
		RespUploadPhoto uploadPhoto=null;
		if (UId!=null && !UId.equals("") && 
				photo!=null && !photo.equals("") &&
				format!=null && !format.equals("")) {
			Users user=(Users) get(Users.class, UId);
 			if (user==null) {
 				uploadPhoto=new RespUploadPhoto("003", null);
			}else {
				try {
					abePath=abePath+"\\photo\\"+UId;
					File file =new File(abePath);    
					//如果文件夹不存在则创建    
					if  (!file .exists()  && !file .isDirectory()){       
						logger.debug("不存在");  
						file .mkdir();    
					} else{  
						logger.debug("目录存在");  
					}
					logger.debug(abePath);
					String photoPath=abePath+"\\"+NameOfDate.getFileName()+"."+format;
					String uPhotoPath=Constant.ABE_WEB_URL+"/photo/"+UId+"/"+NameOfDate.getFileName()+"."+format;
					Base64.getFromBASE64byte(photo, photoPath);
					user.setUPhotoPath(uPhotoPath);
//					logger.debug(uPhotoPath);
					update(user);
//					Users stmp=(Users) get(Users.class, user.getUId());
//					logger.debug(stmp);
					uploadPhoto=new RespUploadPhoto("001", user);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			uploadPhoto=new RespUploadPhoto("002", null);
		}
		return uploadPhoto;
	}
	/**
	 * 李钊 注册
	 * @param uNum
	 * @param uPass
	 * @param uName
	 * @param uType
	 * @return
	 */
	@Override
	public RespSignIn signUpFromApp(String uNum,String uPass,String uName,String ipPhone,String code) {
		List list=find("from Users where UNum=?", new Object[]{uNum});
		if(list.size()>0){
			return new RespSignIn("002", null);
		}else {
			String ipId=NameOfDate.getNum();
			//开始验证
			Code co=(Code) get(Code.class, "admin");
			if (co!=null && code.equals(co.getCCode()) &&
					"admin".equals(co.getUId()) && new Date().before(co.getCNoTime())) {//验证码验证通过
				List<InfoParents> li=find("from InfoParents where ipPhone=?", new String[]{ipPhone});
				if (li!=null && li.size()==0) {//唯一性验证通过
					//1、保存档案
					InfoParents p=new InfoParents(ipId, null, null, null, ipPhone, null);
					save(p);
					//2、保存账号
					Users user=new Users(NameOfDate.getNum(), uNum, uName, uPass, "1", new Timestamp(new Date().getTime()), null, null, ipId,null);
					save(user);
					//在环信系统中注册
					String token=usersSer.getToken(iUsersService.ACCESS_TOKEN);
					String result=usersSer.addUser(user.getUId(), user.getUPass(), token);
					logger.debug("环信注册返回结果："+result);
					return new RespSignIn("001", user);
				}else {
					return new RespSignIn("004", null);
				}
			}else {
				return new RespSignIn("003", null);
			}
		}
	}
	/**
	 * 修改个人资料
	 * 卢江林
	 * @param UNum
	 * @param UName
	 * @param UPass
	 * @param UPhotopath
	 * @param UNote
	 * @param RespUpdateUser 
	 * @return
	 */
	public RespUpdateUser updateUser1(String UNum) {
		//List list=find(" update Users set UName=?,UPass=?,UPhotoPath=?,UNote=? where UNum =?", new Object[]{UName,UPass,UPhotoPath,UNote,UNum});
		List list=find(" from Users where UNum =?", new Object[]{UNum});
		Users u = new Users();
		RespUpdateUser updateUser= new RespUpdateUser();
		if (list.size()>0) {
			u=(Users) list.get(0);
			u.setUPass(null);
			updateUser.setResult("001");
			updateUser.setData(u);
		}else{
			updateUser.setResult("002");
		}
		return updateUser;
	}
	
	public RespUpdateUser updateUser2(String UId,String UName){
		if (UId!=null && UName!=null) {
			Users u = (Users) get(Users.class, UId);
			if (u!=null) {
				if (UName!=null)u.setUName(UName);
				update(u);
				RespUpdateUser updateUser = new RespUpdateUser(); 
				updateUser.setResult("001");
				updateUser.setData(u);
				return updateUser;
			}
		}else {
			return new RespUpdateUser("002", null);
		}
		return null;
	}
	
	public RespCommon updatePass(String uid,String oldpass,String newpass) {
		if (uid!=null && oldpass!=null && newpass!=null) {
			Users user=(Users) get(Users.class, uid);
			if (user!=null && user.getUPass()!=null && oldpass.equals(user.getUPass())) {//验证通过:原密码是对的
				user.setUPass(newpass);
				update(user);
				RespCommon resp=new RespCommon();
				resp.setResult("001");
				resp.setData(null);
				return resp;
			}
		}
		RespCommon common=new RespCommon();
		common.setResult("002");
		common.setData(null);
		return common;
	} 
	
	
	 /**
     *查询个人信息资料
     * 卢江林
     * 11月27日
     */
	public RespUpdateUser queryUsers(String UId){
		List list=find(" from Users where UId =?", new Object[]{UId});
		Users u = new Users();
		RespUpdateUser userInfor= new RespUpdateUser();
		if (list.size()>0) {
			u=(Users) list.get(0);
			userInfor.setData(u);
			userInfor.setResult("001");
		}else{
			userInfor.setResult("002");
		}
		return userInfor;
	}
	@Override
	public RespCommon queryCode(String phone) {
		//发送6位随机数验证码
		if (saveCode("admin", phone, (int)((Math.random()*9+1)*100000)+"")) {
			return getCode("admin");
		}else {
			RespCommon common=new RespCommon();
			common.setResult("002");
			return common;
		}
	}
	
	
}
