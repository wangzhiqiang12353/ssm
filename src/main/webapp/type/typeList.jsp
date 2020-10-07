<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020-09-18
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <table border="1">
         <tr>
             <td>编号</td>
             <td>名称</td>
             <td>电影</td>
         </tr>

         <c:forEach items="${page.list}" var="t">
             <tr>
                 <td>${t.typeid}</td>
                 <td>${t.typename}</td>
                 <td>
                    <c:forEach items="${t.movieList}" var="m">
                     ${m.moviename}  /${m.adress.adressname} /${m.movieYear.yearname}<br>
                    </c:forEach>
                 </td>
             </tr>

         </c:forEach>

     </table>
     <jsp:include page="/common/page.jsp"></jsp:include>

</body>
</html>
