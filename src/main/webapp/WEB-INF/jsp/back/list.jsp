<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.imooc.bean.Massage" %>


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>内容列表页面</title>
		<link href="<%=basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
		<!-- 引入jquery -->
		<script src="<%=basePath %>resources/js/commonjquery-1.8.0.js"></script>
		<script src="<%=basePath %>resources/js/back/list.js"></script>
		
	</head>
	<body style="background: #e1e9eb;">
		<!-- 提交给List.action -->
		<form action="<%=basePath %>List.action" id="mainForm" method="post">
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 
						<!-- javascript:跟上js脚本 -->
						<a class="btn03" href="javascript:void(0)">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;
						
						<!-- 发送批量操作 -->
						<a class="btn03" href="javascript:deleteBatch('<%=basePath%>');">删 除</a>
					</p>
					
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90"  align="right">指令名称：</td>
								<td>
									<input type="text" name="command" class="allInput" value=""/>
								</td>
								<td width="90" align="right">描述：</td>
								<td>
									<input type="text" name="description" class="allInput" value=""/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all" onclick=""/></th>
								    <th>序号</th>
								    <th>演示字段1</th>
								    <th>演示字段2</th>
								    <th>操作</th>
								</tr>
							<%
								// 定义两个变量用于操控页面背景色
								String a = "style='background-color:#ECF6EE'";
								int num = 0;
								
								List<Massage> list = (List<Massage>)request.getAttribute("massageList");
								for(Massage m : list) {
									num++;
							 %>
								<tr>
									<!-- name 为批量删除使用 -->
									<td><input type="checkbox" name = "ids" value = "<%=m.getId() %>" /></td>								
									<td><%=num %></td>								
									<td><%=m.getCommand() %></td>								
									<td><%=m.getDescription() %></td>	
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="<%=basePath %>DeleteOneServlet.action?id=<%=m.getId() %>">删除</a>
									</td>							
								</tr>
							<%
								}							
							 %>
							</tbody>
						</table>
						<div class='page fix'>
							共 <b>4</b> 条
							<a href='###' class='first'>首页</a>
							<a href='###' class='pre'>上一页</a>
							当前第<span>1/1</span>页
							<a href='###' class='next'>下一页</a>
							<a href='###' class='last'>末页</a>
							跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='###' class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>