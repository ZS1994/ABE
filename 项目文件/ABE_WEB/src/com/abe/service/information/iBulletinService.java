package com.abe.service.information;

import com.abe.entity.other.RespBulletin;
import com.abe.entity.other.RespBulletinAll;

/*
 * 公告
 * @author 李钊
 */
public interface iBulletinService {
	/*
	 * 发布公告
	 */
	public RespBulletin insertBulletin(String aiTitle, String aiContent,
			String itId);

	/*
	 * 根据id分页查看所有公告
	 */
	public RespBulletinAll queryBulletinByItId(String pageNo, String pageSize,
			String itId);

	/*
	 * 根据id查看单条公告
	 */
	public RespBulletin findSingleBulletinById(String aiId);

	/*
	 * 分页查看所有公告
	 */
	public RespBulletinAll queryBulletinByPage(String pageNo, String pageSize);

}
