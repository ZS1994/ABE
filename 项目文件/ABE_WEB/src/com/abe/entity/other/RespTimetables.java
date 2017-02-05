package com.abe.entity.other;

import java.util.List;

import com.abe.entity.Timetables;

public class RespTimetables {
	private String result;
	private List<List<Timetables>> data;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<List<Timetables>> getData() {
		return data;
	}
	public void setData(List<List<Timetables>> data) {
		this.data = data;
	}
	
}
