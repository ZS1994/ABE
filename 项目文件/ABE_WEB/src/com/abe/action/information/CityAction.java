package com.abe.action.information;

import java.io.IOException;
import net.sf.json.JSONObject;
import com.abe.action.BaseAction;
import com.abe.action.iBaseAction;
import com.abe.entity.PlaceCity;
import com.abe.entity.PlaceProvince;
import com.abe.entity.other.RespCity;
import com.abe.service.iBaseService;
import com.abe.service.information.iCityService;
import com.abe.tools.NameOfDate;

/**
 * 张顺 2016-11-7 21:03:04
 * 市管理
 * @author 张顺
 */
public class CityAction extends BaseAction implements iBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private iBaseService ser;
	private iCityService citySer;
	
	
	public iBaseService getSer() {
		return ser;
	}
	public void setSer(iBaseService ser) {
		this.ser = ser;
	}
	public iCityService getCitySer() {
		return citySer;
	}
	public void setCitySer(iCityService citySer) {
		this.citySer = citySer;
	}
	
	
	/**
	 * 张顺 2016-11-5 22:41:33<br>
	 * 从APP添加市
	 * @return
	 * @throws IOException 
	 */
	public String addFromApp() throws IOException {
		String pcName=ser.clearSpace(getRequest(), "pcName");
		String ppId=ser.clearSpace(getRequest(), "ppId");
		RespCity city=new RespCity();
		if (ppId==null) {
			city.setResult("003");
			city.setData(null);
		}else if (pcName==null) {
			city.setResult("004");
			city.setData(null);
		}else {
			PlaceProvince province=(PlaceProvince) ser.get(PlaceProvince.class, ppId);
			if (province==null) {
				city.setResult("002");
				city.setData(null);
			}else {
				PlaceCity placeCity=new PlaceCity(NameOfDate.getNum(), pcName, ppId);
				ser.save(placeCity);
				city.setResult("001");
				city.setData(null);
			}
		}
		JSONObject jsonObject=ser.objToJson(city, "yyyy-MM-dd");
		getPrintWriter().print(jsonObject);
		getPrintWriter().flush();
		getPrintWriter().close();
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
	 * <br>从APP查看市详情
	 * @return
	 * @throws IOException 
	 */
	public String queryFromApp() throws IOException {
		String pcId=ser.clearSpace(getRequest(), "pcId");
		RespCity city=new RespCity();
		if (pcId==null) {
			city.setResult("003");
			city.setData(null);
		}else {
			PlaceCity placeCity=(PlaceCity) ser.get(PlaceCity.class, pcId);
			if (placeCity==null) {
				city.setResult("002");
				city.setData(null);
			}else {
				city.setResult("001");
				city.setData(placeCity);
			}
		}
		sendToApp(city, ser);
		return null;
	}
	
	@Override
	public String queryOfFenYe() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 张顺 2016-11-6 21:47:17<br>
	 * 从APP改市数据
	 * @return
	 * @throws IOException 
	 */
	public String updateFromApp() throws IOException {
		String pcName=ser.clearSpace(getRequest(), "pcName");
		String pcId=ser.clearSpace(getRequest(), "pcId");
		RespCity city=new RespCity();
		if (pcId==null) {
			city.setResult("003");
			city.setData(null);
		}else if (pcName==null) {
			city.setResult("004");
			city.setData(null);
		}else {
			PlaceCity placeCity=(PlaceCity) ser.get(PlaceCity.class, pcId);
			if (placeCity==null) {
				city.setResult("002");
				city.setData(null);
			}else {
				placeCity.setPcName(pcName);
				ser.update(placeCity);
				city.setResult("001");
				city.setData(null);
			}
		}
		sendToApp(city,ser);
		return null;
	}
	
	@Override
	public String update() {
		
		
		return null;
	}

	
}
