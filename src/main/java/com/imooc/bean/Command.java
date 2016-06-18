package com.imooc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 对应指令表
 * @author zjh
 *
 */
@SuppressWarnings("serial")
public class Command implements Serializable{
	private Integer id;
	private String command;
	private String description;
	private List<Content> content;
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
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}
	
	
}
