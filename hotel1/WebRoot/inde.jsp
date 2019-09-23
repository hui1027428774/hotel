<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <body>
  <h1>用户列表</h1>
    <c:forEach items="${list}" var="user">
    ${user.username}--- <f:formatDate value="${user.birthday}" pattern="yyyy/MM/dd hh:mm:ss"/><br>
    </c:forEach>
  </body>
</html>
