package com.abe.entity.other;

import java.util.Map;

/**
 * easyui的树模型 2016-12-22
 * @author 张顺
 */
public class UiTree {
	private String id;//节点的 id，它对于加载远程数据很重要。
	private String text;//要显示的节点文本。
	private String iconCls;//树节点的图标
	private String state;//节点状态，'open' 或 'closed'，默认是 'open'。当设置为 'closed' 时，该节点有子节点，并且将从远程站点加载它们。
	private boolean checked;//指示节点是否被选中。
	private Map<String, String> attributes;//给一个节点添加的自定义属性。
	private String children;//定义了一些子节点的节点数组。
	
	
	public UiTree() {
		// TODO Auto-generated constructor stub
	}
	

	public UiTree(String id, String text, String iconCls, String state,
			boolean checked, Map<String, String> attributes, String children) {
		super();
		this.id = id;
		this.text = text;
		this.iconCls = iconCls;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
		this.children = children;
	}


	//----------------------------
	public String getId() {
		return id;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	
	

}

