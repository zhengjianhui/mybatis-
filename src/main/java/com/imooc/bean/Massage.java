package com.imooc.bean;

import java.io.Serializable;

/**
 * list.jsp 页面后台消息表对应 Micro 库 massage 表
 * @author zjh
 *
 */
@SuppressWarnings("serial")
public class Massage implements Serializable{
	// id
	private Integer id;
	// 指令
	private String command;
	// 描述
	private String description;
	// 内容
	private String  content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Massage [id=" + id + ", command=" + command + ", description="
				+ description + ", content=" + content + "]";
	}
	
	
}
