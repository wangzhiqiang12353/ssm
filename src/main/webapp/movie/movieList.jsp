<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020-09-14
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<body>
   <input type="button" onclick="delsMovie()" value="批量删除" >
   <table border="1">
    <tr>
        <td> <input type="checkbox" id="check"></td>
        <td> 电影编号</td>
        <td> 电影名称</td>
        <td> 电影介绍</td>
        <td> 电影类型</td>
        <td> 电影地区</td>
        <td> 电影年代</td>
        <td> 电影评分</td>
        <td> 电影封面</td>
        <td> 上映时间</td>
        <td> 操作</td>
    </tr>
    <c:forEach items="${page.list}" var="m">
        <tr>
            <td> <input type="checkbox" name="movieid" value="${m.movieid}"></td>
            <td> ${m.movieid}</td>
            <td> ${m.moviename}</td>
            <td> ${m.movieshow}</td>
            <td> ${m.movieType.typename}</td>
            <td> ${m.adress.adressname}</td>
            <td> ${m.movieYear.yearname}</td>
            <td> ${m.moviescore}</td>
            <td>

               <img  alt="当前电影暂无封面" src="${m.movieFile.filepath}" width="100px" height="100px">
            </td>
            <td> ${m.movietime}</td>
            <td><a href="javascript:toUpdateMovie(${m.movieid})">修改</a>
                <a href="javascript:deleteMovie(${m.movieid})">删除</a>
            </td>
        </tr>
    </c:forEach>
   </table>
    <jsp:include page="/common/page.jsp"></jsp:include>

</body>
<script>
    $("#check").click(function(){
        $("input[name='movieid']").prop("checked",this.checked)
    })

    function delsMovie(){
        var ids="";
        $("input[name='movieid']").each(function(i){
            if($(this).prop("checked")){
                ids+=","+$(this).val();
            }
        })
        if(ids!=null && ids!=""){
            var idss=ids.substring(1);
            $.ajax({
                url:"<%=request.getContextPath()%>/movie/delsMovie.do",
                data:{"ids":idss},
                type:"post",
                success:function(data){
                    alert("删除成功");
                    location.href="<%=request.getContextPath()%>/movie/toQueryMovie.do";
                },error:function(){
                    alert("删除失败");
                }


            })

        }else{
            alert("请选择要删除的项");
        }
    }



    function toUpdateMovie(movieid){

        location.href="<%=request.getContextPath()%>/movie/toUpdateMovie.do?movieid="+movieid;
    }

    function deleteMovie(movieid){
        if(confirm("你确定删除吗？")){
            $.ajax({
                url:"<%=request.getContextPath()%>/movie/deleteMovie.do",
                data :{"movieid":movieid},
                type:"post",
                success:function (data){
                    alert("删除成功");
                    location.href="<%=request.getContextPath()%>/movie/toQueryMovie.do";
                },error:function(){
                    alert("删除失败");
                }
            })
        }
    }
</script>
</html>
