package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.bean.Massage;
import com.imooc.dbutil.DBAccess;

/**
 * 重构massage
 * @author zjh
 *
 */
public class CommandDao {
	public List<Command> CommandList(String command,String description){
		// 建立工具类
		DBAccess dba = new DBAccess();
		// 声明SqlSession
		SqlSession sqlSession = null;
		// 建立集合保存查询结果
		List<Command> commandList = new ArrayList<Command>();
		
		try {
			// 获取SqlSession
			sqlSession = dba.getSqlSession();
			
			// 建立entity 并传入参数
			Command c = new Command();
			c.setCommand(command);
			c.setDescription(description);
			
			// 通过sqlSession 发送sql语句 对应sql XML的<mapper namespace="Message"> 类似于包名
			// 以及select 查询标签的 id
			// massageList = sqlSession.selectList("Message.selectMassage");
			// sqlSession 支持两个参数，第一个参数哪一个sql.xml的那一条sql语句 第二个参数为查询条件
			// 第二个参数可以将变量封装进entity中 以entity作为第二个参数
			// 使用sqlSession 指定映射的sql语句 并传递参数
			commandList = sqlSession.selectList("Command.queryCommandList",c);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
	
}
