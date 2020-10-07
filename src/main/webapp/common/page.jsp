<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
       <a href="javaScript:serach(1)">首页</a>
       <c:if test="${page.cpage-1==0 }">
       		上一页
       </c:if>
       <c:if test="${page.cpage-1>0 }">
       		<a href="javaScript:serach(${page.cpage-1})">上一页</a>
       </c:if>
       ${page.cpage }/${page.totalPage }
       <c:if test="${page.cpage==page.totalPage }">
       		下一页
       </c:if>
       <c:if test="${page.cpage<page.totalPage }">
       		<a href="javaScript:serach(${page.cpage+1})">下一页</a>
       </c:if>
       <a href="javaScript:serach(${page.totalPage })">尾页</a>
</body>
</html>