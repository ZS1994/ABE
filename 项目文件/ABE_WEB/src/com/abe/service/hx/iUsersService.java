package com.abe.service.hx;

/**
 * 张顺 2016-11-21
 * IM 用户管理
 * @author 张顺
 */
public interface iUsersService {
	
	/*
	 * 日后如果更换这两个关键数据，可直接在这里改即可，其他地方全部引用于此
	 */
	public static final String ORG_NAME="1149161109115389";
	public static final String APP_NAME="abeweb";
	public static final String ADDRESS="https://a1.easemob.com/";
	
	
	public static final String ACCESS_TOKEN="access_token";
	public static final String EXPIRES_IN="expires_in";
	public static final String APPLICATION="application";
	public static final String TOKEN_JSON="token_json";
	
	/**
	 * 获取token
	 * @return
	 */
	public String getToken(String status);
	
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
