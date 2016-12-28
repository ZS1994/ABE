package com.abe.service.information.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.abe.entity.ClassInform;
import com.abe.entity.InfoTeacher;
import com.abe.entity.SchoolClass;
import com.abe.entity.other.RespClassInform;
import com.abe.entity.other.RespClassInformAll;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.service.information.iClassInformService;
import com.abe.tools.NameOfDate;
import com.abe.tools.Page;


public class ClassInformServiceImpl extends BaseServiceImpl implements iClassInformService {

	
	Logger logger=Logger.getLogger(ClassInformServiceImpl.class);
	
	@Override
	public RespClassInform insertClassInform(String ciTitle, String ciContent,
			String scId, String itId) {
		RespClassInform respClassInform = new RespClassInform();
		ClassInform classInform = new ClassInform();
		if (ciTitle == null && "".equals(ciTitle)) {
			respClassInform.setData(null);
			respClassInform.setResult("002");
		} else if (ciContent == null && "".equals(ciContent)) {
			respClassInform.setData(null);
			respClassInform.setResult("003");
		} else if (itId == null && "".equals(itId)) {
			respClassInform.setData(null);
			respClassInform.setResult("004");
		} else if (scId == null && "".equals(scId)) {
			respClassInform.setData(null);
			respClassInform.setResult("005");
		} else {
			String time = getTime();
			NameOfDate nameOfData = new NameOfDate();
			String ciId = nameOfData.getNum();

			classInform.setCiId(ciId);
			classInform.setCiTitle(ciTitle);
			classInform.setCiContent(ciContent);
			classInform.setCiTime(time);
			classInform.setCiStatus("已发布");
			classInform.setItId(itId);
			classInform.setScId(scId);
			save(classInform);

			respClassInform.setData(classInform);
			respClassInform.setResult("001");
		}
		return respClassInform;
	}

	@Override
	public RespClassInformAll findClassInformByPage(String pageNo,
			String pageSize) {
		RespClassInformAll respClassInformAll = new RespClassInformAll();
		ClassInform classInform = new ClassInform();
		int pano = Integer.valueOf(pageNo);
		int size = Integer.valueOf(pageSize);

		if (pano <= 0) {
			respClassInformAll.setResult("002");
			respClassInformAll.setData(null);
		} else if (size <= 0) {
			respClassInformAll.setResult("003");
			respClassInformAll.setData(null);
		} else {
			Page page = new Page(pano, 0, size);
			String hql1 = "from ClassInform group by scId order by ciTime desc ";
			List<ClassInform> list = query(hql1, null, hql1, page);
			for (int i = 0; i < list.size(); i++) {
				InfoTeacher teacher = (InfoTeacher) get(InfoTeacher.class, list
						.get(i).getItId());
				SchoolClass classs = (SchoolClass) get(SchoolClass.class, list
						.get(i).getScId());
				list.get(i).setClasss(classs);
				list.get(i).setTeacher(teacher);
			}
			if (list.size() > 0) {
				respClassInformAll.setData(list);
				respClassInformAll.setResult("001");
			} else {
				respClassInformAll.setData(null);
				respClassInformAll.setResult("004");
			}
		}
		return respClassInformAll;
	}

	@Override
	public RespClassInformAll findClassInformByScId(String pageNo,String pageSize, String scId) {
		RespClassInformAll respClassInformAll = new RespClassInformAll();
		if (pageNo!=null && pageSize!=null && scId!=null) {
			int pano = 0,size = 0;
			try {
				pano = Integer.valueOf(pageNo);
				size = Integer.valueOf(pageSize);
			} catch (Exception e) {
				logger.debug("String 转 int 错误,错误数据源："+pageNo+","+pageSize);
			}
			if (pano <= 0) {
				respClassInformAll.setResult("002");
				respClassInformAll.setData(null);
			} else if (size <= 0) {
				respClassInformAll.setResult("003");
				respClassInformAll.setData(null);
			} else {
				Page page = new Page(pano, 0, size);
				String hql1 = "from ClassInform where scId = ? order by ciTime desc";
				String hql2 = "from ClassInform where scId = '" + scId + "' order by ciTime desc";
				List<ClassInform> list = query(hql1, new String[] { scId }, hql2,page);
				for (int i = 0; i < list.size(); i++) {
					InfoTeacher teacher = (InfoTeacher) get(InfoTeacher.class, list.get(i).getItId());
					SchoolClass classs = (SchoolClass) get(SchoolClass.class, list.get(i).getScId());
					list.get(i).setClasss(classs);
					list.get(i).setTeacher(teacher);
				}
				if (list.size() > 0) {
					respClassInformAll.setResult("001");
					respClassInformAll.setData(list);
				} else {
					respClassInformAll.setResult("004");
					respClassInformAll.setData(null);
				} 
			}
		}
		return respClassInformAll;
	}

	@Override
	public RespClassInform findSingleClassInformById(String ciId) {
		RespClassInform respClassInform = new RespClassInform("002", null);
		if (ciId!=null) {
			ClassInform classInform = (ClassInform) get(ClassInform.class, ciId);
			if (classInform!=null) {
				classInform.setClasss((SchoolClass) get(SchoolClass.class, classInform.getScId()));
				classInform.setTeacher((InfoTeacher) get(InfoTeacher.class, classInform.getItId()));
				respClassInform=new RespClassInform("001", classInform);
				return respClassInform;
			}
		}
		return respClassInform;
	}

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}

}
