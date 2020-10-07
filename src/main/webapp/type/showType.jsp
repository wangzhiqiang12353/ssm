<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020-09-18
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<body>
   <form id="queryTypeFrom">
       类型名称：<input type="text" name="typename" ><br>
       <input type="button" value="查询" onclick="serach(1)"><br>
       <input type="hidden" name="cpage" id="currPage"><br>
       <div id="showType">

       </div>

   </form>
</body>
<script>
    $(function(){
        serach(1);

    })

    function serach (cpage) {
        $("#currPage").val(cpage);
        $.ajax({
            url:"<%=request.getContextPath()%>/type/queryTypeLists.do",
            type:"post",
            data:$("#queryTypeFrom").serialize(),
            dataType:"html",
            success:function (data){
                $("#showType").html(data);
            },error:function () {
             alert("查询失败");
            }

        })

    }

</script>
</html>
