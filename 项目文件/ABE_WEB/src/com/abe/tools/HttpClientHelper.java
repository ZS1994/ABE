package com.abe.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;

import com.abe.service.hx.iHttpClientMutator;



/**
 * 张顺 2016-11-21
 * <br/>Http请求工厂：get、post、put、delete
 * @author it023
 *
 */
public class HttpClientHelper {

	private static Logger log=Logger.getLogger(HttpClientHelper.class);
	private static HttpClientHelper httpClient=null;
	private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	
	
	/*禁止从外部实例化*/
	private HttpClientHelper() {
	}
	
	/**(单例模式)
	 * <br>通过此方法获取示例
	 * */
	public static HttpClientHelper getInstance() {
		if (httpClient==null) {
			//对整个类进行同步处理,并进行后续判断
			synchronized (HttpClientHelper.class) {
				if (httpClient==null) {
					httpClient=new HttpClientHelper();
				}
			}
		}
		return httpClient;
	}
	

	/**
	 * 发送http请求
	 * @param request
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private static String sendRequest(HttpUriRequest request) {
        HttpClient client = new DefaultHttpClient();
        String line = null;
        StringBuffer sb = new StringBuffer();
        try {
            HttpResponse res = client.execute(request);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                InputStreamReader isr = new InputStreamReader(entity.getContent(), HTTP.UTF_8);
                BufferedReader bufr = new BufferedReader(isr);// 缓冲
                while ((line = bufr.readLine()) != null) {
                    sb.append(line);
                }
                isr.close();
            }
        } catch (Exception e) {
            log.error("HTTP服务存在异常，请检查http地址是否能访问！！", e);
            throw new RuntimeException(e);
        } finally {
            // 关闭连接 ,释放资源
            client.getConnectionManager().shutdown();
        }
        return sb.toString();
    }

	/**
	 * 表单参数put请求
	 * @param url 地址
	 * @param values 表单数据
	 * @return 字符串
	 * @throws IOException
	 */
	public static String doPut(String url, List<NameValuePair> values)throws IOException {
		HttpPut httpPut = new HttpPut(url);
		if (values != null) {
			httpPut.setEntity(new UrlEncodedFormEntity(values));
		}
		return sendRequest(httpPut);
	}
	
	/**
	 * json参数put请求
	 * @param url 地址
	 * @param json json参数
	 * @return 字符串
	 * @throws IOException
	 */
	public static String doPut(String url, String json,String token)throws IOException {
		HttpPut httpPut = new HttpPut(url);
		httpPut.addHeader("Content-Type", "application/json;charset=UTF-8");
		httpPut.addHeader("Authorization", "Bearer "+token);
		if (json != null) {
			StringEntity se = new StringEntity(json);
			se.setContentType(CONTENT_TYPE_TEXT_JSON);
			httpPut.setEntity(se);
		}
		return sendRequest(httpPut);
	}
	
	/**
	 * get请求
	 * @param url
	 * @return
	 */
	public static String doGet(String url,String token) {
		HttpGet httpGet=new HttpGet(url);
		httpGet.addHeader("Authorization", "Bearer "+token);
		return sendRequest(httpGet);
	}
	
	/**
	 * 表单参数的post请求
	 * @param url
	 * @param values
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String doPost(String url,List<NameValuePair> values) throws UnsupportedEncodingException {
		HttpPost httpPost=new HttpPost(url);
		if (values != null) {
		    httpPost.setEntity(new UrlEncodedFormEntity(values));
		}
		return sendRequest(httpPost);
	}
	
	
	/**
	 * json参数的post请求
	 * @param url
	 * @param json
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String doPost(String url,String json,String token) throws UnsupportedEncodingException {
		HttpPost httpPost=new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
		if (token!=null) {
			httpPost.addHeader("Authorization", "Bearer "+token);
		}
		if (json != null) {
			StringEntity se = new StringEntity(json);
			se.setContentType(CONTENT_TYPE_TEXT_JSON);
		    httpPost.setEntity(se);
		}
		return sendRequest(httpPost);
	}
	
	/**
	 * 可更改头信息的，以json为参数的，post请求
	 * <br>不太好用，请在必须使用时使用
	 * @param url
	 * @param json
	 * @param token
	 * @param mutator
	 * @return
	 * @throws UnsupportedEncodingException
	public static String doPost(String url,String json,String token,iHttpClientMutator mutator) throws UnsupportedEncodingException {
		HttpPost httpPost=new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
		if (token!=null) {
			httpPost.addHeader("Authorization", "Bearer "+token);
		}
		if (mutator!=null) {
			mutator.setHeader(httpPost);
		}
		if (json != null) {
			StringEntity se = new StringEntity(json);
			se.setContentType(CONTENT_TYPE_TEXT_JSON);
		    httpPost.setEntity(se);
		}
		return sendRequest(httpPost);
	}
	 */
	
	/**
	 * delete请求
	 * @param url
	 * @return
	 */
	public static String doDelete(String url,String token) {
		HttpDelete httpDelete=new HttpDelete(url);
		httpDelete.addHeader("Authorization", "Bearer "+token);
		return sendRequest(httpDelete);
	}
	
	
}
