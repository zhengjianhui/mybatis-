package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MassageDao;

/**
 * 维护相关业务的Service
 * 处理删除新增
 * @author zjh
 *
 */
public class MaintainService {
	
	/**
	 * 单条删除
	 */
	public void deleteOne(String id) {
		// 将Servlet 传递的参数进行处理
		if(id != null && !"".equals(id)) {
			MassageDao dao = new MassageDao();
			dao.deleteOne(Integer.valueOf(id));
		}
	}
	
	/**
	 * 批量删除
	 */
	public void deleteBatch(String[] ids) {
		// 将数组转换成集合并将String 转换成Integer
		List<Integer> coll = new ArrayList<Integer>();
		for(String x : ids) {
			coll.add(Integer.valueOf(x));
		}
		
		MassageDao dao = new MassageDao();
		dao.deleteBatch(coll);
		
	}
}
