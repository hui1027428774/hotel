﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="sys/style/js/jquery.js"></script>
<script type="text/javascript" src="sys/style/js/page_common.js"></script>
<link href="sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="sys/style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 菜品列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>
<script type="text/javascript">
	function cfm(id){
		if(confirm("确定要删除？？？")){
			location.href="dele.do?id="+id;
		}
	}
</script>

	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/wirelessplatform/food.html" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入菜品名称">
			<input type="submit" value="搜索">
		</form>
	</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>菜编号</td>
				<td>菜名</td>
				<td>所属菜系</td>
				<td>价格</td>
                <td>会员价格</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
		<c:forEach items="${plist}" var="p">
			<tr class="TableDetail1">
				<td>${p.id}&nbsp;</td>
				<td>${p.foodName}&nbsp;</td>
				<td>${p.foodTypeName}&nbsp;</td>
				<td>${p.price}&nbsp;</td>
                <td>${p.mprice}&nbsp;</td>
				<td>
					<a href="${pageContext.request.contextPath }/sys/updateFood.jsp"  class="FunctionButton">更新</a>				
					<!-- <a href="${pageContext.request.contextPath }/wirelessplatform/food.jsp?method=delete&id=1" onClick="return delConfirm();"class="FunctionButton">删除</a> -->
					<a href="javascript:cfm(${p.id});" class="FunctionButton">删除</a>		
				</td>
			</tr>
			</c:forEach>
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
	<!-- <div class="FunctionButton"><a href="${pageContext.request.contextPath }/sys/saveFood.jsp">添加</a></div> -->
	<a href="${pageContext.request.contextPath }/toAddFood.do" class="FunctionButton">添加</a>
    </div> 
</div>
</body>
</html>
