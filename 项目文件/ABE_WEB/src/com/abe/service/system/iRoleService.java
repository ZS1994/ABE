package com.abe.service.system;

import java.util.List;

import com.abe.entity.PowerPermission;
import com.abe.entity.PowerRole;

public interface iRoleService {
	
	/**
	 * 通过角色id得到权限明细表
	 * @param rid
	 * @return
	 */
	public List<PowerPermission> queryPers(String rid) ;
	
}
