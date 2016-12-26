package com.abe.service.home;

import java.io.IOException;

import com.abe.entity.Forum;
import com.abe.entity.other.ReqObject;
import com.abe.entity.other.RespForum;
import com.abe.entity.other.RespForumAll;
import com.abe.tools.Page;

public interface iForumService {
	
	/**
	 * 张顺 2016-11-4<br>
	 * 不分页组装分享-评论结构
	 * @param forum
	 * @return
	 */
	public Forum initForACom(Forum forum);
	
	
	/**
	 * 张顺 2016-11-4<br>
	 * 分页组装分享-评论结构
	 * @param forum
	 * @return
	 */
	public Forum initForAComFenYe(Forum forum,Page page);
	
	
	/**
	 * 张顺 2016-11-4<br>
	 * 分页查看所有分享(看不到评论)
	 * @param reqObject
	 * @return
	 */
	public RespForumAll queryOfFenYeForumFromApp(ReqObject reqObject);
	
	
	/**
	 * 张顺 2016-11-4<br>
	 * 分页查看一个分享的评论
	 */
	public RespForum queryOfFenYeCommentFromApp(ReqObject reqObject);
	
	
	/**张顺 2016-11-4<br>
	 * 点赞(+1)
	 * @return
	 */
	public RespForum updateLikeFromApp(ReqObject reqObject);
	
	/**张顺 2016-11-3<br>
	 * APP发表评论
	 * @return
	 * @throws IOException 
	 * @throws IOException
	 */
	public RespForum addCommentFromApp(ReqObject reqObject);
	
	
	
	/**张顺 2016-11-3<br>
	 * 从APP发送分享（班级圈内容，暂称为分享、评论）
	 * @return
	 */
	public RespForum addFromApp(ReqObject reqObject);
}
