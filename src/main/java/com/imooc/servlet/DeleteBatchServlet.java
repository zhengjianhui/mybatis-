package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

/**
 * 处理批量删除
 * @author zjh
 *
 */
public class DeleteBatchServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// 接收一组页面传递的参数
		String[] ids = request.getParameterValues("ids");
		
		// 交给Service层处理
		MaintainService maintainService = new MaintainService();
		maintainService.deleteBatch(ids);
		
		// 转发到list.jsp页面
		request.getRequestDispatcher("List.action").forward(request, response);
		
	
	}
	
}
