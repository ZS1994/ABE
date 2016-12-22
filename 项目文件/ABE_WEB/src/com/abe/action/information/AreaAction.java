package com.abe.action.information;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.PlaceArea;
import com.abe.entity.PlaceCity;
import com.abe.entity.PlaceProvince;
import com.abe.entity.other.ReqObject;
import com.abe.entity.other.RespArea;
import com.abe.entity.other.RespCity;
import com.abe.entity.other.RespCommon;
import com.abe.service.iBaseService;
import com.abe.service.information.iAreaService;
import com.abe.service.information.iCityService;
import com.abe.service.information.iProvinceService;
import com.abe.tools.NameOfDate;

/**
 * 张顺 2016-11-8 10:37:06
 * 区管理
 * @author 张顺
 */
public class AreaAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iAreaService areaSer;
	
	
	
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iAreaService getAreaSer() {
		return areaSer;
	}
	public void setAreaSer(iAreaService areaSer) {
		this.areaSer = areaSer;
	}
	/**
	 * 张顺 2016-11-8 10:37:36<br>
	 * 从APP添加区
	 * @return
	 * @throws IOException 
	 */
	public String addFromApp() throws IOException {
		String paName=ser.clearSpace(getRequest(), "paName");
		String pcId=ser.clearSpace(getRequest(), "pcId");
		RespArea area=new RespArea();
		if (pcId==null) {
			area.setResult("003");
			area.setData(null);
		}else if (paName==null) {
			area.setResult("004");
			area.setData(null);
		}else {
			PlaceCity placeCity=(PlaceCity) ser.get(PlaceCity.class, pcId);
			if (placeCity==null) {
				area.setResult("002");
				area.setData(null);
			}else {
				PlaceArea placeArea=new PlaceArea(NameOfDate.getNum(), paName, pcId);
				ser.save(placeArea);
				area.setResult("001");
				area.setData(null);
			}
		}
		sendToApp(area, ser);
		return null;
	}
	
	
	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSpace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gotoQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 张顺 2016-11-8
	 * <br>从APP查看区详情
	 * @return
	 * @throws IOException 
	 */
	public String queryFromApp() throws IOException {
		String paId=ser.clearSpace(getRequest(), "paId");
		RespCommon area=new RespCommon();
		if (paId==null) {
			area.setResult("003");
			area.setData(null);
		}else {
			PlaceArea placeArea=(PlaceArea) ser.get(PlaceArea.class, paId);
			if (placeArea==null) {
				area.setResult("002");
				area.setData(null);
			}else {
				area.setResult("001");
				area.setData(placeArea);
			}
		}
		sendToApp(area, ser);
		return null;
	}
	
	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 张顺 2016-11-8<br>
	 * 从APP改区数据
	 * @return
	 * @throws IOException 
	 */
	public String updateFromApp() throws IOException {
		String paId=ser.clearSpace(getRequest(), "paId");
		String paName=ser.clearSpace(getRequest(), "paName");
		RespCommon area=new RespCommon();
		if (paId==null) {
			area.setResult("003");
			area.setData(null);
		}else if (paName==null) {
			area.setResult("004");
			area.setData(null);
		}else {
			PlaceArea placeArea=(PlaceArea) ser.get(PlaceArea.class, paId);
			if (placeArea==null) {
				area.setResult("002");
				area.setData(null);
			}else {
				placeArea.setPaName(paName);
				ser.update(placeArea);
				area.setResult("001");
				area.setData(null);
			}
		}
		sendToApp(area,ser);
		return null;
	}
	
	@Override
	public String update() {
		
		
		return null;
	}

	
}
