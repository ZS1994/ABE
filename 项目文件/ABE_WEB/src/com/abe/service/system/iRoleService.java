package com.abe.service.system;

import java.util.List;

import com.abe.entity.PowerPermission;
import com.abe.entity.PowerRole;

public interface iRoleService {
	
	public List<PowerPermission> queryPers(String rid) ;
	
}
