package com.abe.action.home;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.Forum;
import com.abe.entity.ForumComment;
import com.abe.entity.Users;
import com.abe.entity.other.ReqObject;
import com.abe.entity.other.RespForum;
import com.abe.entity.other.RespForumAll;
import com.abe.service.iBaseService;
import com.abe.service.home.iForumService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

/**
 * 班级圈
 * @author 张顺
 *2016-11-3
 */
public class ForumAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iForumService forumSer;
	
	
	public iForumService getForumSer() {
		return forumSer;
	}
	public void setForumSer(iForumService forumSer) {
		this.forumSer = forumSer;
	}
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}

	
	/**张顺 2016-11-3<br>
	 * 从APP发送分享（班级圈内容，暂称为分享、评论）
	 * @return
	 * @throws IOException 
	 */
	public String addFromApp() throws IOException {
		ReqObject reqObject=new ReqObject(getRequest());
		RespForum respForum=forumSer.addFromApp(reqObject);
		JSONObject jsonObject=ser.objToJson(respForum, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
		
	/**张顺 2016-11-3<br>
	 * APP发表评论
	 * @return
	 * @throws IOException
	 */
	public String addCommentFromApp() throws IOException {
		ReqObject reqObject=new ReqObject(getRequest());
		RespForum respForum=forumSer.addCommentFromApp(reqObject);
		JSONObject jsonObject=ser.objToJson(respForum, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
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

	/**
	 * 张顺 2016-11-4<br>
	 * 分页查看所有分享(看不到评论)
	 * @throws IOException 
	 */
	public String queryOfFenYeForumFromApp() throws IOException {
		ReqObject reqObject=new ReqObject(getRequest());
		RespForumAll respForumAll=forumSer.queryOfFenYeForumFromApp(reqObject);
		JSONObject jsonObject=ser.objToJson(respForumAll, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	/**
	 * 张顺 2016-11-4<br>
	 * 分页查看一个分享的评论
	 * @throws IOException 
	 */
	public String queryOfFenYeCommentFromApp() throws IOException {
		ReqObject reqObject=new ReqObject(getRequest());
		RespForum respForum=forumSer.queryOfFenYeCommentFromApp(reqObject);
		JSONObject jsonObject=ser.objToJson(respForum, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	/**张顺 2016-11-4<br>
	 * 点赞(+1)
	 * @return
	 * @throws IOException 
	 */
	public String updateLikeFromApp() throws IOException {
		ReqObject reqObject=new ReqObject(getRequest());
		RespForum respForum=forumSer.updateLikeFromApp(reqObject);
		JSONObject jsonObject=ser.objToJson(respForum, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
	
	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
