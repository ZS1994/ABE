package com.abe.service.hx;

/**
 * 张顺 2016-11-21
 * IM 用户管理
 * @author 张顺
 */
public interface iUsersService {
	
	
	
	
	public static final String ACCESS_TOKEN="access_token";
	public static final String EXPIRES_IN="expires_in";
	public static final String APPLICATION="application";
	public static final String TOKEN_JSON="token_json";
	
	/**
	 * 通过状态标识获取token中得某个信息
	 * @return
	 */
	public String getToken(String status);
	/**
	 * 直接获取token字符串
	 * @return
	 */
	public String getToken();
	
	/**
	 * 添加单个用户
	 * @param name
	 * @param pass
	 * @param token
	 * @return
	 */
	public String addUser(String name,String pass,String token);
	
	
	/**
	 * 查看某个用户的信息
	 * @param name
	 * @param token
	 * @return
	 */
	public String queryUser(String name,String token);
	
	
	
	
}
