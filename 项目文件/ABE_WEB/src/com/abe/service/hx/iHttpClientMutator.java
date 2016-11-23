package com.abe.service.hx;


import org.apache.http.client.methods.HttpUriRequest;

/**
 * 张顺 2016-11-22
 * <br>HttpClientHelper修改器
 * <br>已废弃，原因：使用不方便
 * @author 张顺
 */
@Deprecated
public interface iHttpClientMutator {
	
	public boolean setHeader(HttpUriRequest request);
}
