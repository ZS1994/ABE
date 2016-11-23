package com.abe.service.hx;

/**
 * 文件上传下载
 * <ul>
 * <li>只有 APP 的登录用户才能够上传文件。</li>
 * <li>在上传文件的时候可以选择是否限制访问权限。</li>
 * <li>如果选择限制的话，会在上传请求完成后返回一个 secret，只有知道这个 secret，并且是 APP 的注册用户，才能够下载文件。</li>
 * <li>如果选择不限制的话，则只要是 APP 的注册用户就能够下载。</li>
 * </ul>
 * @author it023
 */
public interface iFileService {

	
	
	public String chatfiles(Boolean restrict_access,String token);
	
}
