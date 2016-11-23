package com.abe.service.hx;

/**
 * 张顺 2016-11-22
 * <br>在线与离线
 * @author 张顺
 */
public interface iStatusService {

	/**
	 * 查看用户在线状态
	 * <br>查看一个用户的在线状态。
	 * @param username
	 * @param token
	 * @return
	 */
	public String getState(String username,String token);
	

	/**
	 * 查询离线消息数
	 * <br>获取一个 IM 用户的离线消息数。
	 * @param username
	 * @param token
	 * @return
	 */
	public String getOfflineMessageNumber(String username,String token);
	
	/**
	 * 查询某条离线消息状态
	 * <br>通过离线消息的 ID 查看用户的该条离线消息状态。消息ID可以通过获取聊天记录查询。
	 * @param username
	 * @param msgId
	 * @param token
	 * @return
	 */
	public String getOfflineMessageState(String username,String msgId,String token);
	
	
	/**
	 * 用户账号禁用
	 * <br>禁用某个 IM 用户的账号，禁用后该用户不可登录，下次解禁后该账户恢复正常使用。
	 * @param username
	 * @param token
	 * @return
	 */
	public String Deactivate(String username,String token);
	
	/**
	 * 用户账号解禁
	 * <br>解除对某个 IM 用户账号的禁用，解禁后用户恢复正常使用。
	 * @param username
	 * @param token
	 * @return
	 */
	public String Activate(String username,String token);
	
	
	/**
	 * 强制用户下线
	 * <br>如果某个 IM 用户已经登录环信服务器，强制其退出登录。
	 * @param username
	 * @param token
	 * @return
	 */
	public String Disconnect(String username,String token);
	
}
