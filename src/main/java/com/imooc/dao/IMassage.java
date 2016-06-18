package com.imooc.dao;

import java.util.List;

import com.imooc.bean.Massage;

/**
 * 接口式编程
 * 代理sql语句
 * @author zjh
 *
 */
public interface IMassage {

	// 定义一个公有方法 返回值对应结果集 方法名对应sql语句id 参数为sql参数类型
	public List<Massage> selectMassage(Massage massage) ;
}
