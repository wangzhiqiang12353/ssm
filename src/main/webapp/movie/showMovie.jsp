<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020-09-14
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- <style></style>是去掉汉字超链接 下的横线的-->
    <style type="text/css">
        a:visited {text-decoration-line: none}
        a:link {text-decoration-line: none}
        a:hover {text-decoration-line: none}
        a:active {text-decoration-line: none}
    </style>
</head>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<body>

      <form id="queryForm">
          电影名称：<input type="text" name="moviename"><br>
          电影评分：<input type="text" name="startScore">-----<input type="text" name="endScore"><br>
          上映时间：<input type="date" name="startTime">-----<input type="date" name="endTime"><br>
          <input type="button" onclick="serach(1)" value="查询">
          <input type="hidden" name="typeid" id="type" ><br>
          <div id="showType">
          </div>
          <input type="hidden" name="adressid" id="adress" ><br>
          <div id="showAdress">
          </div>
          <input type="hidden" name="yearid" id="year" ><br>
          <div id="showYear">
          </div>

          <input type="hidden" name="cpage" id="currPage">
          <div id="showMovie">

          </div>

      </form>
</body>
<script>
    $(function(){
        getType();
        getAdress();
        getYear();
        serach(1);
    })

    function getType(){
        $.ajax({
            url:"<%=request.getContextPath()%>/type/queryTypeList.do",
            type:"post",
            dataType:"json",
            success:function(data){
                var str="类型：<a href='javascript:setType(-1)'>全部</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";//&nbsp; 表示空格
                for (var i=0; i<data.length;i++){
                   str+="<a href='javascript:setType("+data[i].typeid+")'>"+data[i].typename+"</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
              }
              $("#showType").html(str);

            },error:function(){
                alert("查询失败");

            }

        })
    }

    function getAdress(){
        $.ajax({
            url:"<%=request.getContextPath()%>/adress/queryAdressList.do",
            type:"post",
            dataType:"json",
            success:function(data){
                var str="地区：<a href='javascript:setAdress(-1)'>全部</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";//&nbsp; 表示空格
                for (var i=0; i<data.length;i++){
                    str+="<a href='javascript:setAdress("+data[i].adressid+")'>"+data[i].adressname+"</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                }
                $("#showAdress").html(str);

            },error:function(){
                alert("查询失败");

            }

        })
    }

    function getYear(){
        $.ajax({
            url:"<%=request.getContextPath()%>/year/queryYearList.do",
            type:"post",
            dataType:"json",
            success:function(data){
                var str="年代：<a href='javascript:setYear(-1)'>全部</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";//&nbsp; 表示空格
                for (var i=0; i<data.length;i++){
                    str+="<a href='javascript:setYear("+data[i].yearid+")'>"+data[i].yearname+"</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                }
                $("#showYear").html(str);

            },error:function(){
                alert("查询失败");

            }

        })
    }

    function setType(typeid) {
        if(typeid!=-1){
            $("#type").val(typeid);
            serach(1);
        }
        else{
            $("#type").val("") ;
            serach(1);
        }
    }

    function  setAdress(adressid) {
        if(adressid!=-1){
            $("#adress").val(adressid);
            serach(1);
        }
        else{
            $("#adress").val("") ;
            serach(1);
        }
    }

    function setYear(yearid){
        if(yearid!=-1){
            $("#year").val(yearid);
            serach(1);
        }
        else{
            $("#year").val("") ;
            serach(1);
        }

    }


    function serach(cpage) {
        $("#currPage").val(cpage);
       $.ajax({
           url:"<%=request.getContextPath()%>/movie/queryMovieList.do",
           type:"POST",
           data:$("#queryForm").serialize(),
           dataType:"html",
           success: function(data){
               $("#showMovie").html(data);
           },error:function(){
               alert("查询失败");
           }

       });

    }

</script>
</html>
