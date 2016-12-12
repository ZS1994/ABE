package com.abe.test;

import java.util.Calendar;
import java.util.Date;

public class TestCalendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date=new Date();
		Calendar calendar=Calendar.getInstance();   
		calendar.setTime(date); 
		calendar.add(Calendar.MINUTE, 1);
		System.out.println(calendar.getTime().toLocaleString());//加1之后的日期Top 
	}

}
