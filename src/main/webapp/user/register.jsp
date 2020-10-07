<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020-09-19
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/uploadify/uploadify.css">
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/uploadify/jquery.uploadify.min.js"></script>
<body>
   <h1>注册60秒幸福一辈子</h1>
    <form id="regFrom" action="<%=request.getContextPath()%>/user/register.do" onsubmit="return checkAll()">
        用户名：<input type="text" id="username" name="username" onblur="checkName()" placeholder="请输入用户名"><span id="sp1"></span><br>
        密码：<input type="password" id="pwd" placeholder="请输入密码"  onblur="checkPwd1()"><span id="sp2"></span><br>
        确认密码：<input type ="password" id="pwd2" name="userpwd" placeholder="请输入确认密码" onblur="checkPwd2()"><span id="sp3"></span><br>
        头像：    <img id="add_img" width="100px" height="100px" /><span id="sp4"></span>
                <!-- 文件域 -->
                <input type="file" name="image" id="uploadImg"/>
                <!-- 隐藏域：用于向后台传值 name的值需要自己改 -->
                <input type="hidden" id="hideImg" name="movieFile.filepath" />
                <!-- 显示进度条的div -->
                <div id="fileQueue"></div><br>

        <input type="submit" value="注册">
    </form>
</body>
<script>
    var flog1=true;
    /**
     * 验证用户名是否存在
     */
    function checkName(){
      var username= $("#username").val();
      if(username!=null&&username!=""){
          $("#sp1").html("");
          $.ajax({
              url:"<%=request.getContextPath()%>/user/queryUserByName.do",
              type:"post",
              data:$("#regFrom").serialize(),
              dataType:"json",
              async:false,
              success: function(data){
                  if(data=="1"){
                      $("#sp1").html("<font color=red >用户名已存在 请重新输入</font>");
                      false1=false;
                  }
                  if(data=="2"){
                      $("#sp1").html("<font color=green >√</font>");
                      false1=true;
                  }

              },error:function(){
                  alert("验证失败")
              }
          })
      }else{
          $("#sp1").html("<font color=red >用户名不能为空</font>");
          return false;
      }
    }

    /**
     * 验证俩次密码是否一致
     */
   function checkPwd2(){
       var pwd=$("#pwd").val();
        var pwd2=$("#pwd2").val();
        if(pwd!=null&&pwd!=""){
            $("#sp2").html("");
            if(pwd2!=null&&pwd2!=""){
                $("#sp3").html("");
                if(pwd==pwd2){
                    $("#sp2").html("<font color=green >√</font>");
                    $("#sp3").html("<font color=green >√</font>");
                    return true;
                }else{
                    $("#sp2").html("<font color=red >俩次密码不一致</font>");
                    $("#sp3").html("<font color=red >俩次密码不一致</font>");
                    return false;
                }


            }else{
                $("#sp3").html("<font color=red >确认密码不能为空</font>");
                return false;
            }
            }else{
            $("#sp2").html("<font color=red >密码不能为空</font>");
            return false;
        }

    }

    /**
     * 验证密码
      */
    function checkPwd1(){
        var pwd=$("#pwd").val();

        if(pwd!=null&&pwd!=""){

            $("#sp2").html("<font color=green >√</font>");
            return true;
        }else{
            $("#sp2").html("<font color=red >密码不能为空</font>");
            return false;
        }

    }


    /**
     * 验证所有
     */
    function checkAll(){
        var flag0=checkName();
        var flag2=checkPwd1();
        var flag3=checkPwd2();
        var flag4=false;
        var path=$("#hideImg").val();
        if(path!=null && path!=""){
            flag4=true;
            $("#sp4").html("<font color=green >√</font>");
        }else{
            $("#sp4").html("<font color=red >头像不能为空</font>");
        }
        if(flag1 && flag2 && flag3 && flag4 && flsg0){
            return true;
        }

        return  false;
    }


    //文件上传插件uploadfiy
    $("#uploadImg").uploadify({
        //插件自带  不可忽略的参数flash插件
        'swf': '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
        //前台请求后台的url 不可忽略的参数  需要自己改
        'uploader': '<%=request.getContextPath()%>/user/uploadUserImg.do',
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

</script>
</html>
