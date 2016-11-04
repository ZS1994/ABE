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
import com.abe.entity.app.ReqObject;
import com.abe.entity.app.RespForum;
import com.abe.service.iBaseService;
import com.abe.service.home.iForumService;
import com.abe.tools.NameOfDate;

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

	
	/**
	 * 从APP发送分享（班级圈内容，暂称为分享、评论）
	 * @return
	 * @throws IOException 
	 */
	public String addFromApp() throws IOException {
		ReqObject reqObject=new ReqObject(getRequest());
		reqObject.add("UId");
		reqObject.add("FContent");
		String uid=reqObject.getToString("UId");
		RespForum respForum=new RespForum();
		if (uid==null) {
			respForum.setResult("003");
		}else {
			Users user=(Users) ser.get(Users.class, uid);
			if (user==null) {
				respForum.setResult("002");
			}else {
				Forum forum=new Forum(NameOfDate.getNum(), reqObject.getToString("FContent"), (Integer)0,new Timestamp(new Date().getTime()), uid);
				forum.setUser(user);
				List<ForumComment> comments=ser.find("from ForumComment where FId=? order by fcCreateTime desc", new String[]{forum.getFId()});
				for (int i = 0; i < comments.size(); i++) {
					Users user2=(Users) ser.get(Users.class, comments.get(i).getUId());
					comments.get(i).setUser(user2);
				}
				forum.setComment(comments);
				respForum.setResult("001");
				respForum.setData(forum);
			}
		}
		JSONObject jsonObject=ser.objToJson(respForum, "yyyy-MM-dd HH:mm:ss");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
		return null;
	}
		
	/**
	 * APP发表评论
	 * @return
	 * @throws IOException
	 */
	public String addCommentFromApp() {
		
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
