<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%    
String path = request.getContextPath();    
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%> 
<html>
<head>
	<!-- base需要放到head中 -->    
	<base href=" <%=basePath%>">  
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>请假管理系统-注册</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/jquery.min.js"></script>
</head>
<body data-type="login">
    <script src="assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 风格切换 -->
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div class="tpl-skiner-content-title">
                    选择主题
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>
        <div class="tpl-login">
            <div class="tpl-login-content">
                <div class="tpl-login-title">注册用户</div>
                <span class="tpl-login-content-info">
                  	创建一个新的用户
              </span>
                <form class="am-form tpl-form-line-form" action="actIdUserController/register"  name="actionForm" id="actionForm"  method="post">
                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" id="user-name" name="id" placeholder="请输入用户名" required>
                    </div>

                    <div class="am-form-group">
                        <input type="password" class="tpl-form-input" id="user-name" name="pwd" placeholder="请输入密码" required>
                    </div>

                    <div class="am-form-group">
                        <input type="password" class="tpl-form-input" id="user-name" name="repwd" placeholder="再次输入密码" required>
                    </div>

                    <!-- <div class="am-form-group">
                        <input type="text" class="tpl-form-input" id="user-name" name="post" placeholder="请输入岗位" required>
                    </div>
                    
      				<div class="am-form-group">
                        <input type="text" class="tpl-form-input" id="user-name" name="system" placeholder="请输入部门" required>
                    </div> -->
                    
                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" id="user-name" name="email" placeholder="请输入邮箱" required>
                    </div>
                    
                    <div class="am-form-group tpl-login-remember-me">
                        <input id="remember-me" type="checkbox">
                        <label for="remember-me">
       
                        我已阅读并同意 <a href="javascript:;">《用户注册协议》</a> 
                         </label>

                    </div>
                    <div class="am-form-group">

                        <button type="submit" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交</button>

                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/app.js"></script>

</body>
</html>