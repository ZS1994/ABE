package com.abe.test;

import java.util.ArrayList;
import java.util.List;

import com.abe.entity.app.RespCommon;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonArraylistTest {
	public static void main(String[] args) {
		List<List<String>> list=new ArrayList<List<String>>();
		List<String> list2=new ArrayList<String>();
		list2.add("A");
		list2.add("B");
		list2.add("C");
		List<String> list3=new ArrayList<String>();
		list3.add("A");
		list3.add("B");
		list3.add("C");
		list.add(list2);
		list.add(list3);
		RespCommon common=new RespCommon();
		common.setResult("001");
		common.setData(list);
		JSONObject obj=JSONObject.fromObject(common);
		System.out.println(obj);
		
		
	}
}
