package com.imooc.bean;

import java.io.Serializable;

/**
 * 指令表的关联表
 * 对应相对指令的内容
 * @author zjh
 *
 */
@SuppressWarnings("serial")
public class Content implements Serializable{
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCommand_id() {
		return command_id;
	}
	public void setCommand_id(Integer command_id) {
		this.command_id = command_id;
	}
	private Integer id;
	private String content;
	private Integer command_id;
	
	// 子表包含主表 entity
	private Command command;
	
}
