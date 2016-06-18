package com.imooc.service;

import java.awt.Robot;
import java.util.List;
import java.util.Random;

import com.imooc.bean.Command;
import com.imooc.bean.Content;
import com.imooc.bean.Massage;
import com.imooc.dao.CommandDao;
import com.imooc.dao.MassageDao;
import com.imooc.util.Iconst;

/**
 * 查询相关的业务功能
 * @author zjh
 *
 */
public class QueryService {
	
	public List<Massage> select(String command,String description) {
		MassageDao dao = new MassageDao();
		List<Massage> list = dao.selectMassage(command, description);
		return list;
	}
	
	/**
	 * 根据指令
	 */
	public String queryByCommand(String command) {
		CommandDao dao = new CommandDao();
		// 如果是帮助指令则查询所有字段返回
		List<Command> list;
		// 常量帮助 传入的是帮助则全表查询
		if(Iconst.HELP_COMMAND.equals(command)) {
			// 传入两个null值，使massage 做全字段查询
			list = dao.CommandList(null, null);
			
			// 使用StringBuilder 拼接所有结果返回
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < list.size(); i++) {
				// 第一行不需要换行
				if(i != 0) {
					sb.append("<br>");
				}
				sb.append("回复[" + list.get(i).getCommand() + "]可以查看" + list.get(i).getDescription());
			}
			return sb.toString();
		}
		
		// 如果是具体指令这查询对应的
		list = dao.CommandList(command, null);
		// 若结果集大于则随机一条
		if(list.size() > 0) {
			// 返回查询到第一条结果 的内容
			List<Content> content = list.get(new Random().nextInt(list.size())).getContent();
			// 获取指令bean 中的 Content集合 取其中一个
			return content.get(0).getContent();
			
		}
		// 从常量接口中获取返回值
		return Iconst.NO_MATCHING_CONTENT;
	}
}
