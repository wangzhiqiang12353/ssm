<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020-09-19
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<body>
<form id="loginForm">
    用户名：<input type="text" id="username" onblur="checkUserName()" name="username"><span id="sp1"></span> <br>
    密码：<input type="password" id="userpwd" name="userpwd" onblur="checkPwd()"><span id="sp2"></span><br>
    验证码：<input type="text" onblur="checkImgCode()" name="imgcode" id="imgcode2"><span id="sp3"></span><br>
    <img src="<%=request.getContextPath()%>/user/imgCode.do" id="imgCode"><br>
    <input type="button" value="登录" onclick="login()">
    <input type="button" value="注册" onclick="register()">

</form>
</body>
<script type="text/javascript">
    /**
     * 生成随机的验证码
     */
    $("#imgCode").click(function(){
        $(this).attr("src","<%=request.getContextPath()%>/user/imgCode.do?t="+new Date().getTime());
    })
    /**
     * 注册方法
      */
    function register(){
        location.href="<%=request.getContextPath()%>/user/toReg.do"
    }
    //登录
    function login() {
        var username = $("#username").val();
        var userpwd = $("#userpwd").val();
        var imgcode2 = $("#imgcode2").val();
        if(imgcode2!=null &&imgcode2!=""){
            if(username!=null && username!=""){
                $("#sp1").html("");
                if(userpwd!=null && userpwd!=""){
                    $("#sp2").html("");
                    $.ajax({
                        url:"<%=request.getContextPath()%>/user/login.do",
                        type:"post",
                        data:$("#loginForm").serialize(),
                        dataType:"json",
                        success:function (data) {
                            if(data=="1"){
                                $("#sp3").html("<font color='red'>验证码错误</font>");
                            }
                            if(data=="2"){
                                $("#sp1").html("<font color='red'>用户名错误</font>");
                            }
                            if(data=="3"){
                                $("#sp2").html("<font color='red'>密码错误</font>");
                            }
                            if(data=="4"){
                                location.href="<%=request.getContextPath()%>/index.jsp";
                            }
                        },error:function () {
                            alert("登录失败");
                        }
                    })
                }else{
                    $("#sp2").html("<font color='red'>用密码不能为空</font>");
                    return false;
                }
            }else{
                $("#sp1").html("<font color='red'>用户名不能为空</font>");
                return false;
            }
        }else {
            $("#sp3").html("<font color='red'>验证码不能为空</font>");
            return false;
        }

    }

    /**
     * 验证用户名不能为空
     * @returns {boolean}
     */
    function checkUserName() {
        var username = $("#username").val();
        if(username!=null && username!=""){
            $("#sp1").html("");
            return true;
        }else{
            $("#sp1").html("<font color='red'>用户名不能为空</font>");
            return false;
        }
    }


    /**
     * 验证密码不能为空
     * @returns {boolean}
     */
    function checkPwd() {
        var userpwd = $("#userpwd").val();
        if(userpwd!=null && userpwd!=""){
            $("#sp2").html("");
            return true;
        }else{
            $("#sp2").html("<font color='red'>密码不能为空</font>");
            return false;
        }
    }

    /**
     * 验证验证码不能为空
     * @returns {boolean}
     */
    function checkImgCode() {
        var imgcode2 = $("#imgcode2").val();
        if(imgcode2!=null && imgcode2!=""){
            $("#sp3").html("");
            return true;
        }else{
            $("#sp3").html("<font color='red'>验证码不能为空</font>");
            return false;
        }
    }

</script>
</html>
