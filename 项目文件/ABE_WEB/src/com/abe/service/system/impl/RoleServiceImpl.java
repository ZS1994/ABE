package com.abe.service.system.impl;

import java.util.List;

import com.abe.entity.PowerPermission;
import com.abe.entity.PowerRole;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.service.system.iRoleService;

public class RoleServiceImpl extends BaseServiceImpl implements iRoleService{

	@Override
	public List<PowerPermission> queryPers(String rid) {
		if (rid!=null && !rid.equals("0")) {
			List<PowerPermission> list=find("from PowerPermission where PId in (select PId from PowerRolePermission where RId=?)", new String[]{rid});
			return list;
		}else{
			List<PowerPermission> list=find("from PowerPermission", null);
			return list;
		}
	}

}
