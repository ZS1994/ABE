package com.abe.service.home;

import com.abe.entity.app.RespNews;
import com.abe.entity.app.RespNewsAll;

/*
 * 新闻模块各种功能
 * @author 李钊
 */
public interface iNewsService {
	/*
	 * 发布新闻
	 * @param News
	 */
	public RespNews insertNews(String NTitle, String NContent, String NImgs,
			String NUrl, String NOrigin, String NType, String NIstop, String UId, String NStatus);
	/*
	 * 修改新闻
	 */
	public RespNews upDateNews(String NId,String NTitle, String NContent, String NImgs,
			String NUrl, String NOrigin, String NType, String NCreatTime,
			String NFinalTime, String NIstop, String UId, String NStatus);
	/*
	 * 根据ID查询单条新闻
	 * 
	 */
	public RespNews findSingleNews(String NId);
	/*
	 * 分页查看新闻
	 * 
	 */
	public RespNewsAll findAllNewsByPage(String pageNo,String pageSize);
	/*
	 * 分页查询所有状态为展示的新闻
	 */
	public RespNewsAll findAllNewsOnByPage(String pageNo,String pageSize,String NStatus,String NIstop,String NFinalTime);
}
