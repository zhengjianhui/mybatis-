package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 会话页的初始化
 */
public class InitTalkServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("utf-8");
		
		// 转发到list.jsp页面
		request.getRequestDispatcher("WEB-INF/jsp/front/talk.jsp").forward(request, response);
		
	}
	
}
