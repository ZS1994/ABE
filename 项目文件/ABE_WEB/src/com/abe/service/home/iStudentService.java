package com.abe.service.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.abe.entity.InfoStudent;
import com.abe.entity.app.ReqObject;
import com.abe.entity.app.RespStudent;

public interface iStudentService {
	
	/**张顺<br>
	 * 通过学号查找学生 2016-11-2
	 * @param isNum 学号
	 * @return
	 */
	public InfoStudent getFromNum(String isNum);
	
	/**
	 * 张顺 2016-11-26 15:06:48
	 * 通过id查学生信息，且装填过其他信息
	 * @param isId
	 * @return
	 */
	public InfoStudent getFromId(String isId);
	
	
	/**
	 * app端添加学生【添加宝贝】
	 * @param req
	 * @return
	 */
	public RespStudent addFromApp(HttpServletRequest req);
	
	/**
	 * 绑定学生
	 * @param req
	 * @return
	 */
	public RespStudent addRel(String ipId,String isId,String spRelation);
	
	
	
	/**
	 * 张顺 2016-12-1
	 * 得到所有学生信息
	 * @return
	 */
	public List<InfoStudent> getAllStu();
	
	
}
