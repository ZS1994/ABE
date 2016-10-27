package com.abe.tools;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
	/**
	 *  字符串，BASE64 编码 
	 * @param s
	 * @return
	 */
	public static String getBASE64(String s) { 
	if (s == null) return null; 
	return (new sun.misc.BASE64Encoder()).encode( s.getBytes() ); 
	} 

	/**
	 *  字符串， BASE64 解码 
	 * @param s
	 * @return
	 */
	public static String getFromBASE64(String s) { 
		if (s == null) return null; 
			BASE64Decoder decoder = new BASE64Decoder(); 
			try { 
			byte[] b = decoder.decodeBuffer(s); 
			return new String(b); 
		} catch (Exception e) { 
			return null; 
		} 
	}
	

	/**
	 * 文件,BASE64 编码
	 */
	public static String getBASE64(File file) {
		 InputStream inputStream =null;
		 String fileString=null;
		  try {
		        inputStream = new FileInputStream(file);
		        byte [] fileByte = new byte[inputStream.available()];
		        fileString = new BASE64Encoder().encode(fileByte);
		  } catch(Exception e) {
		        e.printStackTrace();
		  } finally {
		        if(inputStream != null){
		              try {
		                    inputStream.close();
		              } catch (IOException e) {
		                    e.printStackTrace();
		              }
		        }
		  }
		  return fileString;
	}
	/**
	 * 网络资源, BASE64 编码
	 * @throws IOException 
	 */
	public static String getBASE64FromUrl(String urlstring) throws IOException {
		 URL url = new URL(urlstring);    
		 HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
         //设置超时间为5秒  
		 conn.setConnectTimeout(5*1000); 
		 //防止屏蔽程序抓取而返回403错误  
	     conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
	     //得到输入流  
	     InputStream inputStream = conn.getInputStream();  
		 StringBuilder fileBuilder=new StringBuilder();
		  try {
			  ByteArrayOutputStream out = new ByteArrayOutputStream();
			  byte[] temp = new byte[1024];
			  for(int len = inputStream.read(temp); len != -1;len = inputStream.read(temp)){
	                out.write(temp, 0, len);
	                fileBuilder.append(new BASE64Encoder().encode(out.toByteArray()));
	                out.reset();
			  }
		  } catch(Exception e) {
		        e.printStackTrace();
		  } finally {
		        if(inputStream != null){
		              try {
		                    inputStream.close();
		              } catch (IOException e) {
		                    e.printStackTrace();
		              }
		        }
		  }
		  return fileBuilder.toString();
	}
	
	/**
	 *   BASE64 解码成文件
	 * @param fileStream 编码字符串
	 * @param filePath 要保存到的路径
	 * @return
	 * @throws IOException
	 */
	public static void getFromBASE64byte(String fileStream,String filePath) throws IOException { 
		  byte [] fileByte = new BASE64Decoder().decodeBuffer(fileStream);
	      BufferedOutputStream stream = null;
	      File file = null;
	      try {
	            file = new File(filePath);
	            FileOutputStream fstream = new FileOutputStream(file);
	            stream = new BufferedOutputStream(fstream);
	            stream.write(fileByte);
	      } catch(Exception e) {
	            e.printStackTrace();
	      } finally {
	            if(stream!= null){
	                  try {
	                        stream.close();
	                  } catch (IOException e) {
	                        e.printStackTrace();
	                  }
	            }
	      }
	}
	
}
