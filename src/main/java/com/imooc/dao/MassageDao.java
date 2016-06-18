package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.imooc.bean.Massage;
import com.imooc.dbutil.DBAccess;

/**
 * 和Massage表相关的
 * @author zjh
 *
 */
public class MassageDao {
/**
 * 根据查询条件查询消息列表
 */
public List<Massage> select2(String command,String description) {
	
	
	// 建立集合保存 每一条 massage 记录
	List<Massage> mas = new ArrayList<Massage>();
	
	Connection conn = null;
	try {
				
		Class.forName("com.mysql.jdbc.Driver");

		conn
			=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Micro?useUnicode=true&characterEncoding=UTF-8"
					,"root"
					,"root"
					);
			
			// 不要写*号，不然减低数据库效率，数据库还需要将*解析成字段名
			// 使用StringBuilder 减少重复new String对象      where 1=1 恒成立 用于给予后续条件判定
			StringBuilder sql = new StringBuilder("select id,command,description,content from message where 1 = 1 ");
			
			// 建立集合用于缓存参数
			List<String> paramList = new ArrayList<String>();
			
			// 用于判断查询 参数不能null 也不能是空字符串  trim()去除空白字符
			if(command != null && !"".equals(command.trim())) {
				// 在where 1=1 的前提上增加sql语句
				sql.append("and command = ? ");
				// 若参数不为空则将参数增添到list集合中
				paramList.add(command);
			}
			if(description != null && !"".equals(description.trim())) {
				// 描述做一个模糊查询  %模糊任意位  _模糊一位 字符串拼接用 空格拼
				sql.append("and description like '%' ? '%' ");
				// 若参数不为空则将参数增添到list集合中
				paramList.add(description);
			}
			
			// 发送查询语句 将StringBuilder 转换成String发送
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			
			
			// 判断 条件集合 并发送条件，
			for(int i = 1; i <= paramList.size(); i++) {
				ps.setString(i, paramList.get(i-1));
			}
			
			// 接收结果集合
			ResultSet rs = ps.executeQuery();
			// 实例massage 表实体类
			Massage ma = new Massage();
			
			// 迭代结果集
			while(rs.next()) {
				ma.setId(Integer.valueOf(rs.getInt("id")));
				ma.setCommand(rs.getString("command"));
				ma.setDescription("Description");
				ma.setContent("content");
				mas.add(ma);
			}
			
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return mas;
	
}

	
	/**
	 * 查询方法
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Massage> selectMassage(String command,String description){
		// 建立工具类
		DBAccess dao = new DBAccess();
		// 声明SqlSession
		SqlSession sqlSession = null;
		// 建立集合保存查询结果
		List<Massage> massageList = new ArrayList<Massage>();
		
		try {
			// 获取SqlSession
			sqlSession = dao.getSqlSession();
			
			// 建立entity 并传入参数
			Massage massage = new Massage();
			massage.setCommand(command);
			massage.setDescription(description);
			
			// 通过sqlSession 发送sql语句 对应sql XML的<mapper namespace="Message"> 类似于包名
			// 以及select 查询标签的 id
			// massageList = sqlSession.selectList("Message.selectMassage");
			// sqlSession 支持两个参数，第一个参数哪一个sql.xml的那一条sql语句 第二个参数为查询条件
			// 第二个参数可以将变量封装进entity中 以entity作为第二个参数
			// 使用sqlSession 指定映射的sql语句 并传递参数
//			massageList = sqlSession.selectList("Massage.selectMassage",massage);
			
			// 接口式编程 用接口代理sql语句
			// 将接口的Class传给mybatis 的 映射方法 返回该接口实例 参考代理者模式源码编译
			IMassage iMassage =  sqlSession.getMapper(IMassage.class);
			massageList = iMassage.selectMassage(massage);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return massageList;
	}
	
	/**
	 * 单行删除
	 * @param id
	 */
	public void deleteOne(int id) {
		// 建立工具类
		DBAccess db = new DBAccess();
		// 声明SqlSession对象
		SqlSession sqlSession = null;
		try {
			// 实例SqlSession
			sqlSession
				= db.getSqlSession();
			
			sqlSession.delete("Massage.deleteOne",id);
			// mybatis 的查询是自动事物，而增删改是手动事物，这里需要手动提交
			sqlSession.commit();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 批量删除
	 * @param args
	 */
	public void deleteBatch(List<Integer> ids) {
		// 实例工具类
		DBAccess da = new DBAccess();
		// 声明连接对象
		SqlSession sqlSession = null;
		try {
			// 获取连接
			sqlSession = da.getSqlSession();
			// 发送数据
			sqlSession.delete("Massage.deleteBatch", ids);
			// 处理事务
			sqlSession.commit();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
	}
	
	public static void main(String[] args) {
		MassageDao dao = new MassageDao();
		dao.selectMassage("", "");
		Map<String, Massage> map = new HashMap<String, Massage>();
		map.put("key", new Massage());
		
//		// 日志
//		Logger log;
//		log.debug("asd");
//		log.info(message);
//		log.warn(message);
//		log.error(message);
	}
	
	
}
