package com.imooc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Massage;
import com.imooc.service.QueryService;


/**
 * 该类是列表页面初始化
 * @author zjh
 *
 */
// 序列化注解
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			// 设置字符集
			request.setCharacterEncoding("utf-8");
			// 接受页面传值
			String command = request.getParameter("command");
			System.out.println(command);
			String description = request.getParameter("description");
			// 向页面传值
			request.setAttribute("command", command);
			request.setAttribute("description", description);
			
			
			// 查询消息列表
			QueryService ls = new QueryService();
			List<Massage> mas = ls.select(command, description);

			// 保存与请求中
			request.setAttribute("massageList", mas);
		
		
		// 转发到list.jsp页面
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	

	
}
