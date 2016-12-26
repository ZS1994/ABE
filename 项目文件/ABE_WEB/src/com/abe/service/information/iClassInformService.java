package com.abe.service.information;

import com.abe.entity.other.RespClassInform;
import com.abe.entity.other.RespClassInformAll;

/*
 * 班级通知
 * @author 李钊
 */
public interface iClassInformService {

	/*
	 * 发布班级通知
	 */
	public RespClassInform insertClassInform(String ciTitle, String ciContent,
			String scId, String itId);

	/*
	 * 查看单条班级通知
	 */
	public RespClassInform findSingleClassInformById(String ciId);

	/*
	 * 根据班级编号分页查看所有班级通知
	 */
	public RespClassInformAll findClassInformByScId(String pageNo,
			String pageSize, String scId);

	/*
	 * 分页查看所有班级通知
	 */
	public RespClassInformAll findClassInformByPage(String pageNo,
			String pageSize);
}
