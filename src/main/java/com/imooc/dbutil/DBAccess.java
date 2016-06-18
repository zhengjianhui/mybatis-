package com.imooc.dbutil;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;




/**
 * 该类用于访问数据库
 * 
 * 
 * 
 * mybatis 对jdbc的二次封装
 * @author zjh
 *
 */
public class DBAccess {

	public SqlSession getSqlSession() throws IOException {
		
		// 通过配置文件获取连接数据库的信息  org.apache.ibatis.io.Resources;
		// web 目录都在src 下
		Reader reader = Resources.getResourceAsReader("com/imooc/config/Configuration.xml");
		
		// 通过配置信息构建一个SqlSessionFactory
		// 通过SqlSessionFactoryBuilder() 的 build(reader) 读取配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		 // 通过SqlSessionFactoryBuilder 打开数据库会话
		 // 通过SqlSessionFactory 的 方法获取 一个SqlSession对象
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		
		 
		 return sqlSession;
		
	}
	
	
	public static void main(String[] args) {
		DBAccess access = new DBAccess();
		
		SqlSession sqlSession = null;
		try {
			sqlSession = access.getSqlSession();
			
			// 通过SqlSession执行sql语句
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭会话
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
	}
}
