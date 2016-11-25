package com.abe.entity.app;

import java.util.List;
import java.util.Map;

/**
 * 张顺 2016-11-24
 * 环信：发送文本信息请求体
 * @author张顺 
 */
public class ReqMesText {

	private String target_type;
	private List<String> target;
	private Map<String, String> msg;
	private String from;
	
	
	public String getTarget_type() {
		return target_type;
	}
	public void setTarget_type(String targetType) {
		target_type = targetType;
	}
	public List<String> getTarget() {
		return target;
	}
	public void setTarget(List<String> target) {
		this.target = target;
	}
	public Map<String, String> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
}
