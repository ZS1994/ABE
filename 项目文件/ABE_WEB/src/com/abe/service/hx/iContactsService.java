package com.abe.service.hx;

/**
 * 张顺 2016-11-22
 * <br>好友与黑名单
 * @author 张顺
 */
public interface iContactsService {

	
	/**
	 * 加好友
	 * @param ownerUsername
	 * @param friendUsername
	 * @param token
	 * @return
	 */
	public String addFriend(String ownerUsername,String friendUsername,String token);
	
	
	/**
	 * 删除好友
	 * @param ownerUsername
	 * @param friendUsername
	 * @param token
	 * @return
	 */
	public String removeFriend(String ownerUsername,String friendUsername,String token);
	
	
	/**
	 * 查看用户的好友
	 * @param ownerUsername
	 * @param token
	 * @return
	 */
	public String queryFriend(String ownerUsername,String token);
	
	/**
	 * 获取 IM 用户的黑名单
	 * <br>获取一个IM用户的黑名单。黑名单中的用户无法给该 IM 用户发送消息。
	 * @param ownerUsername
	 * @param token
	 * @return
	 */
	public String queryBlacklist(String ownerUsername,String token);
	
	
	/**
	 * 往 IM 用户的黑名单中加人
	 * <br>往一个 IM 用户的黑名单中加人，一次可以添加一个或多个。黑名单中的用户无法给该 IM 用户发送消息。
	 * @param ownerUsername
	 * @param blacklistUsernames
	 * @param token
	 * @return
	 */
	public String addBlacklist(String ownerUsername,String blacklistUsernames[],String token);
	
	/**
	 * 从 IM 用户的黑名单中减人
	 * <br>从一个 IM 用户的黑名单中减人。将用户从黑名单移除后，恢复好友关系，可以互相收发消息。
	 * @param ownerUsername
	 * @param blacklistUsername
	 * @param token
	 * @return
	 */
	public String removeBlacklist(String ownerUsername,String blacklistUsername,String token);
	
	
	
}
