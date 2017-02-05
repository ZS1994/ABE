package com.abe.service.information.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.abe.entity.AllInform;
import com.abe.entity.InfoTeacher;
import com.abe.entity.Return;
import com.abe.entity.SchoolClass;
import com.abe.entity.Users;
import com.abe.entity.other.RespReturn;
import com.abe.entity.other.RespReturnAll;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.service.information.iReturnService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

public class ReturnServiceImpl extends BaseServiceImpl implements
		iReturnService {

	@Override
	public RespReturnAll findAllReturnsByPage(String pageNo, String pageSize,
			String rStatus) {
		RespReturnAll respReturnAll = new RespReturnAll();
		Return returns = new Return();
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);

		if (pano <= 0) {
			respReturnAll.setResult("002");
			respReturnAll.setData(null);
		} else if (size <= 0) {
			respReturnAll.setResult("003");
			respReturnAll.setData(null);
		} else {
			Page page = new Page(pano, 0, size);
			String hql1 = "from Return order by RTime desc ";
			List<Return> list = query(hql1, null, hql1, page);
			for (int i = 0; i < list.size(); i++) {
				Users user = (Users) get(Users.class, list
						.get(i).getUId());
				list.get(i).setUser(user);
			}
			if (list.size() > 0) {
				respReturnAll.setData(list);
				respReturnAll.setResult("001");
			} else {
				respReturnAll.setData(null);
				respReturnAll.setResult("004");
			}
		}
		return respReturnAll;
	}

	@Override
	public RespReturn findSingleReturn(String rId) {
		RespReturn respReturn = new RespReturn();
		if (rId == null && "".equals(rId)) {
			respReturn.setData(null);
			respReturn.setResult("003");
		} else{
		Return returns =(Return) get(Return.class,rId);
		returns.setRStatus("已查看");
		update(returns);
		respReturn.setData(returns);
		respReturn.setResult("001");
		}
		return respReturn;
	}

	@Override
	public RespReturn insertReturn(String rContent, String uId) {
		RespReturn respReturn = new RespReturn();
		Return returns = new Return();
		if (rContent == null && "".equals(rContent)) {
			respReturn.setData(null);
			respReturn.setResult("002");
		} else if (uId == null && "".equals(uId)) {
			respReturn.setData(null);
			respReturn.setResult("003");
		} else{
		String time = getTime();
		NameOfDate nameOfData = new NameOfDate();
		String rId = nameOfData.getNum();
		
		returns.setRContent(rContent);
		returns.setRId(rId);
		returns.setUId(uId);
		returns.setRStatus("未查看");
		returns.setRTime(time);
		save(returns);
		respReturn.setData(returns);
		respReturn.setResult("001");
		
		}
		return respReturn;
	}

	@Override
	public RespReturn updateReturn(String rId, String rStatus) {
		RespReturn respReturn = new RespReturn();
		if (rStatus == null && "".equals(rStatus)) {
			respReturn.setData(null);
			respReturn.setResult("002");
		} else if (rId == null && "".equals(rId)) {
			respReturn.setData(null);
			respReturn.setResult("003");
		} else{
		Return returns =(Return) get(Return.class,rId);
		returns.setRStatus(rStatus);
		update(returns);
		respReturn.setData(returns);
		respReturn.setResult("001");
		}
		return respReturn;
	}
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}

	@Override
	public void initRet(List<Return> rets) {
		if (rets!=null) {
			for (int i = 0; i < rets.size(); i++) {
				initRet(rets.get(i));
			}
		}
	}

	@Override
	public void initRet(Return ret) {
		//装填用户
		if (ret!=null) {
			Users user=(Users) get(Users.class, ret.getUId());
			if (user!=null) {
				user.setUPass(null);
				ret.setUser(user);
			}
		}
	}
}
