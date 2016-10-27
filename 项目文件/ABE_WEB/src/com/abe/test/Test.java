package com.abe.test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.abe.tools.Base64;
import com.abe.tools.NameOfDate;

public class Test {
	public static void main(String[] args) throws URISyntaxException, IOException {
		
		/*
		 * 测试 json时间格式转换问题
		String format ="yyyy-MM-dd HH:mm:ss"; 
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA); 
		Timestamp timestamp=new Timestamp(new Date().getTime());
        System.out.println("-----sdf.format------->>"+sdf.format(timestamp));
		 */
		/*
		 *测试不重复随机数 
		System.out.println(NameOfDate.getNum());
		 */
		
		/*
		 * 测试Base64编解码
		 */
		//测试网络文件编码
		String filesString=Base64.getBASE64FromUrl("http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/photo/271634032221266/271634032221266.png");
//		System.out.println(filesString);
		//解码成文件--失败
		Base64.getFromBASE64byte(filesString, "F://a.png");
		//测试字符串的编解码
		filesString=Base64.getBASE64("同一个世界");
//		String tmpString=
		
		
		
	}
}
