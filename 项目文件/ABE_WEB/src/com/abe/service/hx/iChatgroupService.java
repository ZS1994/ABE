package com.abe.service.hx;

/**
 * 张顺 2016-11-22
 * 群组管理
 * @author 张顺
 */
public interface iChatgroupService {

	/**
	 * 获取 APP 中所有的群组
	 * @param token
	 * @return
	 */
	public String queryChatgroups(String token);
	
	
	
	/**
	 * 获取群组详情
	 * <br>可以获取一个或多个群组的详情。当获取多个群组的详情时，会返回所有存在的群组的详情，对于不存在的群组，response body内返回“group id doesn't exist”。
	 * @param token
	 * @param groupids
	 * @return
	 */
	public String queryChatgroupsInfo(String token,String groupids[]);
	
	
	
	
	/**
	 * 创建一个群组
	 * @param json
	 * @param token
	 * @return
	 */
	public String createChatgroup(String json,String token);
	
	
	
	
	
	/**修改群组信息
	 * 修改成功的数据行会返回 true，失败为 false。请求 body 只接收 groupname、description、maxusers　三个属性，传其他字段会被忽略。
	 * <br>注意：修改 groupname ​和 description ​时，如果需要使用空格，请用“+”替换。如需要写“test group1”，请用“test+group1”代替。
	 * @param groupid
	 * @param json
	 * @param token
	 * @return
	 */
	public String updateChatgroup(String groupid,String json,String token);
	
	
	
	/**
	 * 删除群组
	 * @param groupid
	 * @param token
	 * @return
	 */
	public String deleteChatgroup(String groupid,String token);
	
	
	/**
	 * 获取群组所有成员
	 * @param groupid
	 * @param token
	 * @return
	 */
	public String queryChatgroupUsers(String groupid,String token);
	
	
	/**
	 * 添加群组成员[单个]
	 * @param groupid
	 * @param username
	 * @param token
	 * @return
	 */
	public String addUser(String groupid,String username,String token);
	
	
	
	/**
	 * 添加群组成员[批量]
	 * @param groupid
	 * @param usernames
	 * @param token
	 * @return
	 */
	public String addUsers(String groupid,String usernames[],String token);
	
	
	/**
	 * 移除群组成员[单个]
	 * @param groupid
	 * @param username
	 * @param token
	 * @return
	 */
	public String removeUser(String groupid,String username,String token);
	
	
	/**
	 * 移除群组成员[批量]
	 * @param groupid
	 * @param usernames
	 * @param token
	 * @return
	 */
	public String removeUsers(String groupid,String usernames[],String token);
	
	
	/**
	 * 获取一个用户参与的所有群组
	 * @param username
	 * @param token
	 * @return
	 */
	public String queryGroupOfUser(String username,String token);
	
	
	
	/**转让群组
	 * <br>修改群组 Owner 为同一 APP 下的其他用户。
	 * <br>注意：将群组 Owner 转让给其他用户后，原 Owner 可能被删除。如果希望原 Owner 作为成员继续留在该群组中，需要再次将该用户添加至群组。
	 * @param groupid
	 * @param newowner
	 * @param token
	 * @return
	 */
	public String overGroup(String groupid,String newowner,String token);
	
	
	
	
}
