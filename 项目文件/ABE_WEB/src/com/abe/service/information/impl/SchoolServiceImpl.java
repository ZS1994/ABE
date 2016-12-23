package com.abe.service.information.impl;

import java.util.List;

import com.abe.entity.PlaceArea;
import com.abe.entity.PlaceCity;
import com.abe.entity.PlaceProvince;
import com.abe.entity.School;
import com.abe.service.impl.BaseServiceImpl;
import com.abe.service.information.iSchoolService;

public class SchoolServiceImpl extends BaseServiceImpl implements iSchoolService{

	@Override
	public List<School> allFullName(List<School> ls) {
		for(int i = 0 ; i< ls.size() ; i++){
			if(ls.get(i).getPaId()!=null&&!ls.get(i).equals("")){
				PlaceArea pa = (PlaceArea) get(PlaceArea.class, ls.get(i).getPaId());
				String paname = pa.getPaName();
					PlaceCity pc = (PlaceCity) get(PlaceCity.class, pa.getPcId());
					String pcname = pc.getPcName();
						PlaceProvince pp = (PlaceProvince) get(PlaceProvince.class, pc.getPpId());
						String ppname = pp.getPpName();
						ls.get(i).setAreaFullName(ppname+" "+pcname+" "+paname);
			}else{
				ls.get(i).setAreaFullName("（无）");
			}
		}
		return ls;
	}

}
