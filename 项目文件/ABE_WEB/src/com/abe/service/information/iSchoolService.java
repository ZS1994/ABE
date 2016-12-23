package com.abe.service.information;

import java.util.List;

import com.abe.entity.School;

public interface iSchoolService {

	/**
	 *将省市区的消息一起带过去
	 *@author 张顺 
	 */
	public List<School> allFullName(List<School> ls);
}
