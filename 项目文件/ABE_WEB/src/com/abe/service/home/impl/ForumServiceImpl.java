package com.abe.service.home.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.abe.entity.Forum;
import com.abe.entity.ForumComment;
import com.abe.entity.ForumLike;
import com.abe.entity.Users;
import com.abe.entity.other.ReqObject;
import com.abe.entity.other.RespForum;
import com.abe.entity.other.RespForumAll;
import com.abe.service.home.iForumService;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

public class ForumServiceImpl extends BaseServiceImpl implements iForumService{

	@Override
	public Forum initForACom(Forum forum) {
		//组装Forum（分享+评论）
		Users user=(Users) get(Users.class, forum.getUId());
		forum.setUser(user);
		List<ForumComment> comments=find("from ForumComment where FId=? order by fcCreateTime desc", new String[]{forum.getFId()});
		for (int i = 0; i < comments.size(); i++) {
			Users user2=(Users) get(Users.class, comments.get(i).getUId());
			comments.get(i).setUser(user2);
		}
		forum.setComment(comments);
		return forum;
	}

	@Override
	public Forum initForAComFenYe(Forum forum, Page page) {
		Users user=(Users) get(Users.class, forum.getUId());
		forum.setUser(user);
		String hql1="from ForumComment where FId=? order by fcCreateTime desc";
		String hql2="from ForumComment where FId='"+forum.getFId()+"' order by fcCreateTime desc";
		List<ForumComment> comments=query(hql1, new String[]{forum.getFId()}, hql2, page);
		for (int i = 0; i < comments.size(); i++) {
			Users user2=(Users) get(Users.class, comments.get(i).getUId());
			user2.setUPass(null);//去掉密码信息
			comments.get(i).setUser(user2);
		}
		forum.setComment(comments);
		return forum;
	}

	@Override
	public RespForumAll queryOfFenYeForumFromApp(ReqObject reqObject) {
		RespForumAll respForumAll=new RespForumAll();
		reqObject.add("pageNo");
		reqObject.add("size");
		int pano=reqObject.getToInteger("pageNo");
		int size=reqObject.getToInteger("size");
		if (pano<=0) {
			respForumAll.setResult("002");
			respForumAll.setData(null);
		}else if (size<=0) {
			respForumAll.setResult("003");
			respForumAll.setData(null);
		}else {
			Page page=new Page(pano, 0, size);
			String hql="from Forum order by FCreateTime desc";
			List<Forum> forums=query(hql, null, hql, page); 
			for (int i = 0; i < forums.size(); i++) {
				Users user=(Users) get(Users.class, forums.get(i).getUId());
				user.setUPass(null);
				forums.get(i).setUser(user);
			}
			respForumAll.setResult("001");
			respForumAll.setData(forums);
		}
		return respForumAll;
	}

	@Override
	public RespForum queryOfFenYeCommentFromApp(ReqObject reqObject) {
		RespForum respForum=new RespForum();
		reqObject.add("pageNo");
		reqObject.add("size");
		reqObject.add("FId");
		int pano=reqObject.getToInteger("pageNo");
		int size=reqObject.getToInteger("size");
		String fid=reqObject.getToString("FId");
		if (pano<=0) {
			respForum.setResult("002");
			respForum.setData(null);
		}else if (size<=0) {
			respForum.setResult("003");
			respForum.setData(null);
		}else if(fid==null){
			respForum.setResult("005");
			respForum.setData(null);
		}else{
			Forum forum=(Forum) get(Forum.class, fid);
			if (forum==null) {
				respForum.setResult("004");
				respForum.setData(null);
			}else {
				Page page=new Page(pano, 0, size);
				initForAComFenYe(forum, page);
				respForum.setResult("001");
				respForum.setData(forum);
			}
		}
		return respForum;
	}

	@Override
	public RespForum updateLikeFromApp(ReqObject reqObject) {
		RespForum respForum=new RespForum();
		reqObject.add("FId");
		reqObject.add("like");
		reqObject.add("UId");
		String fid=reqObject.getToString("FId");
		String like=reqObject.getToString("like");
		String uid=reqObject.getToString("UId");
		if (fid==null) {
			respForum.setResult("003");
			respForum.setData(null);
		}else if (like==null) {
			respForum.setResult("004");
			respForum.setData(null);
		}else if (uid==null) {
			respForum.setResult("006");
			respForum.setData(null);
		}else {
			Forum forum=(Forum) get(Forum.class, fid);
			Users user=(Users) get(Users.class, uid);
			if (forum==null) {
				respForum.setResult("002");
				respForum.setData(null);
			}else if (user==null) {
				respForum.setResult("005");
				respForum.setData(null);
			}else {
				List<ForumLike> likes=find("from ForumLike where UId=? and FId=?", new String[]{uid,fid});
				if (likes.size()>0) {
					respForum.setResult("007");
					respForum.setData(null);
				}else {
					forum.setFLike(forum.getFLike()+1);
					update(forum);
					ForumLike like2=new ForumLike(NameOfDate.getNum(), fid, uid);
					save(like2);
					respForum.setResult("001");
					respForum.setData(null);
				}
			}
		}
		return respForum;
	}

	@Override
	public RespForum addCommentFromApp(ReqObject reqObject) {
		RespForum respForum=new RespForum();
		reqObject.add("UId");
		reqObject.add("fcContent");
		reqObject.add("FId");
		String uid=reqObject.getToString("UId");
		String fid=reqObject.getToString("FId");
		if (uid==null) {
			respForum.setResult("004");
			respForum.setData(null);
		}else if (fid==null) {
			respForum.setResult("005");
			respForum.setData(null);
		}else {
			Users user=(Users) get(Users.class, uid);
			Forum forum=(Forum) get(Forum.class, fid);
			if (user==null) {
				respForum.setResult("002");
				respForum.setData(null);
			}else if(forum==null){
				respForum.setResult("003");
				respForum.setData(null);
			}else {
				ForumComment comment=new ForumComment(NameOfDate.getNum(), reqObject.getToString("fcContent"), new Timestamp(new Date().getTime()), uid, fid);
				save(comment);
				respForum.setResult("001");
				respForum.setData(null);
			}
		}
		return respForum;
	}

	@Override
	public RespForum addFromApp(ReqObject reqObject) {
		RespForum respForum=new RespForum();
		reqObject.add("UId");
		reqObject.add("FContent");
		String uid=reqObject.getToString("UId");
		if (uid==null) {
			respForum.setResult("003");
		}else {
			Users user=(Users) get(Users.class, uid);
			if (user==null) {
				respForum.setResult("002");
			}else {
				Forum forum=new Forum(NameOfDate.getNum(), reqObject.getToString("FContent"), (Integer)0,new Timestamp(new Date().getTime()), uid);
				save(forum);
				respForum.setResult("001");
				respForum.setData(null);
			}
		}
		return respForum;
	}

	
	
}
