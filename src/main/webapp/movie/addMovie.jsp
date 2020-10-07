<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020-09-16
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/kindeditor-4.1.10/themes/default/default.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/uploadify/uploadify.css">
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/js/kindeditor-4.1.10/kindeditor-all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/uploadify/jquery.uploadify.min.js"></script>
<body>
  <form id="addMovieForm">

      电影名称：<input type="text" name="moviename"><br>
      电影评分：<input type="text" name="moviescore"><br>
      上映时间：<input type="date" name="movietime"><br>
      电影类型：<select name="movieType.typeid">
                  <option value="">请选择</option>
              <c:forEach items="${movieTypes}" var="t">
                  <option value="${t.typeid}">${t.typename}</option>
              </c:forEach>
              </select><br>
      电影地区：<select name="adress.adressid">
                  <option value="">请选择</option>
               <c:forEach items="${adresses}" var="a">
                  <option value="${a.adressid}">${a.adressname}</option>
               </c:forEach>
               </select><br>
      电影年代：<select name="movieYear.yearid">
                   <option value="">请选择</option>
               <c:forEach items="${movieYears}" var="y">
                   <option value="${y.yearid}">${y.yearname}</option>
               </c:forEach>
               </select><br>
      电影介绍： <textarea id="content" name="movieshow"></textarea><br>

      电影封面：  <img id="add_img" width="100px" height="100px" />
              <!-- 文件域 -->
              <input type="file" name="image" id="uploadImg"/>
              <!-- 隐藏域：用于向后台传值 name的值需要自己改 -->
              <input type="hidden" id="hideImg" name="movieFile.filepath" />
              <!-- 显示进度条的div -->
              <div id="fileQueue"></div><br>
      <input type="button" onclick="addMovie()" value="新增">

  </form>


</body>
<script>
    //新增电影
    function addMovie() {
        $.ajax({
            url:"<%=request.getContextPath()%>/movie/addMovie.do",
            type:"post",
            data:$("#addMovieForm").serialize(),
            success:function (data) {
                location.href=location.href;
            },error:function () {
                alert("新增失败");
            }
        });
    }

    //文件上传插件uploadfiy
    $("#uploadImg").uploadify({
        //插件自带  不可忽略的参数flash插件
        'swf': '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
        //前台请求后台的url 不可忽略的参数  需要自己改
        'uploader': '<%=request.getContextPath()%>/movie/uploadMovieImg.do',
        //给div的进度条加背景 不可忽略
        'queueID': 'fileQueue',
        //上传文件文件名 跟file标签 name值 保持一致
        'fileObjName' : 'image',
        //给上传按钮设置文字
        'buttonText': '上传图片',
        //设置文件是否自动上传
        'auto': true,
        //可以同时选择多个文件 默认为true  不可忽略
        'multi': true,
        //上传后队列是否消失
        'removeCompleted': true,
        //允许上传的文件后缀 
        'fileExt': '*.jpg;*.gif;*.png',
        //
        'cancelImg': '<%=request.getContextPath()%>/js/uploadify/uploadify-cancel.png',
        //队列消失时间
        'removeTimeout' : 1,
        //上传文件的个数，项目中一共可以上传文件的个数
        'uploadLimit':  -1,
        'fileTypeExts': '*.jpg;*.png',
        //成功回调函数 file：文件对象。data后台输出数据
        'onUploadSuccess':function(file,data,response){
            //alert(file.name+" 路径："+data)
            var imgurl = "http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"+data;
            //图片回显， 预览
            $("#add_img").attr("src",imgurl)
            // 文本框 回填
            $('#hideImg').val(imgurl);
        }
    });
    //富文本编辑器
    var editor;
    KindEditor.ready(function(K) {
        //将编辑器添加到文档中
        editor = K.create('#content', {
            cssPath : '<%=request.getContextPath()%>/js/kindeditor-4.1.10/plugins/code/prettify.css',
            //指定编辑器iframe document的CSS文件，用于设置可视化区域的样式。
            uploadJson: "<%=request.getContextPath()%>/js/kindeditor-4.1.10/jsp/upload_json.jsp",
            //指定上传文件的服务器端程序。
            fileManagerJson: "<%=request.getContextPath()%>/js/kindeditor-4.1.10/jsp/file_manager_json.jsp",
            //指定浏览远程图片的服务器端程序。
            allowFileManager : true,
            //true时显示浏览远程服务器按钮 ;默认值: false
            //将富文本编辑中的内容同步到表单序列化中
            afterBlur:function(){this.sync();}
        });
    });
</script>
</html>
