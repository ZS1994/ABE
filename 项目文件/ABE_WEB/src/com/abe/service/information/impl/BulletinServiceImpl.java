package com.abe.service.information.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.abe.entity.AllInform;
import com.abe.entity.InfoTeacher;
import com.abe.entity.other.RespBulletin;
import com.abe.entity.other.RespBulletinAll;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.service.information.iBulletinService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;

public class BulletinServiceImpl extends BaseServiceImpl implements
		iBulletinService {

	@Override
	public RespBulletin insertBulletin(String aiTitle, String aiContent,
			String itId) {
		RespBulletin respBulletin = new RespBulletin();
		AllInform allInform = new AllInform();
		if (aiTitle == null && "".equals(aiTitle)) {
			respBulletin.setData(null);
			respBulletin.setResult("002");
		} else if (aiContent == null && "".equals(aiContent)) {
			respBulletin.setData(null);
			respBulletin.setResult("003");
		} else if (itId == null && "".equals(itId)) {
			respBulletin.setData(null);
			respBulletin.setResult("004");
		} else {
			String time = getTime();
			NameOfDate nameOfData = new NameOfDate();
			String aiId = nameOfData.getNum();

			allInform.setAiId(aiId);
			allInform.setAiTitle(aiTitle);
			allInform.setAiContent(aiContent);
			allInform.setAiTime(time);
			allInform.setItId(itId);
			allInform.setAiStatus("已发布");
			save(allInform);

			respBulletin.setData(allInform);
			respBulletin.setResult("001");
		}
		return respBulletin;
	}

	@Override
	public RespBulletinAll queryBulletinByItId(String pageNo, String pageSize,
			String itId) {
		RespBulletinAll respBulletinAll = new RespBulletinAll();
		AllInform allInform = new AllInform();
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);

		if (pano <= 0) {
			respBulletinAll.setResult("002");
			respBulletinAll.setData(null);
		} else if (size <= 0) {
			respBulletinAll.setResult("003");
			respBulletinAll.setData(null);
		} else {
			Page page = new Page(pano, 0, size);
			List<AllInform> list;
			if(itId == null || "".equals(itId)){
				String hql = "from AllInform order by aiTime desc";
				list = query(hql,null,hql,page);
			}else{
			String hql1 = "from AllInform where itId = ? order by aiTime desc";
			String hql2 = "from AllInform where itId = '" + itId
					+ "' order by aiTime desc";
			list = query(hql1, new String[] { itId }, hql2,
					page);
			}
			for (int i = 0; i < list.size(); i++) {
				InfoTeacher teacher = (InfoTeacher) get(InfoTeacher.class, list
						.get(i).getItId());
				list.get(i).setTeacher(teacher);
			}
			if (list.size() > 0) {

				respBulletinAll.setData(list);
				respBulletinAll.setResult("001");
			} else {

				respBulletinAll.setData(null);
				respBulletinAll.setResult("004");
			}
		}
		return respBulletinAll;
	}

	@Override
	public RespBulletin findSingleBulletinById(String aiId) {
		RespBulletin respBulletin = new RespBulletin();
		AllInform allInform = new AllInform();
		allInform = (AllInform) get(AllInform.class, aiId);
		respBulletin.setData(allInform);
		respBulletin.setResult("001");
		return respBulletin;
	}

	@Override
	public RespBulletinAll queryBulletinByPage(String pageNo, String pageSize) {
		RespBulletinAll respBulletinAll = new RespBulletinAll();
		AllInform allInform = new AllInform();
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);

		if (pano <= 0) {
			respBulletinAll.setResult("002");
			respBulletinAll.setData(null);
		} else if (size <= 0) {
			respBulletinAll.setResult("003");
			respBulletinAll.setData(null);
		} else {
			Page page = new Page(pano, 0, size);
			String hql1 = "from AllInform order by aiTime desc ";
			List<AllInform> list = query(hql1, null, hql1, page);
			for (int i = 0; i < list.size(); i++) {
				InfoTeacher teacher = (InfoTeacher) get(InfoTeacher.class, list
						.get(i).getItId());
				list.get(i).setTeacher(teacher);
			}
			if (list.size() > 0) {
				respBulletinAll.setData(list);
				respBulletinAll.setResult("001");
			} else {
				respBulletinAll.setData(null);
				respBulletinAll.setResult("004");
			}
		}
		return respBulletinAll;
	}

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}

}
