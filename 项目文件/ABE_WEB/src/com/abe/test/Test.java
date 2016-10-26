package com.abe.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test {
	public static void main(String[] args) {
		
		/*
		 * 测试 json时间格式转换问题
		 */
		String format ="yyyy-MM-dd HH:mm:ss"; 
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA); 
		Timestamp timestamp=new Timestamp(new Date().getTime());
        System.out.println("-----sdf.format------->>"+sdf.format(timestamp));
		
	}
}
