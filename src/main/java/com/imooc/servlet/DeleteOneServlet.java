package com.imooc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Massage;
import com.imooc.service.QueryService;
import com.imooc.service.MaintainService;

@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			// 设置字符集
			request.setCharacterEncoding("utf-8");
			// 接受页面传值
			String id = request.getParameter("id");
			
			MaintainService maintainService = new MaintainService();
			// 将判定页面传递的字符转转换int 的工作交给Service处理
			maintainService.deleteOne(id);
		
		// 转发到list.jsp页面
		request.getRequestDispatcher("List.action").forward(request, response);
	}
}
