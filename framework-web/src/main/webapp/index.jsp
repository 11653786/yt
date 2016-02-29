<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2015/8/11
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入自定义标签-->
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resource/images/favicon.ico"/>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/resource/css/login.css" type="text/css" media="screen"
          rel="stylesheet"/>
    <style type="text/css">
        #code {
            height: 30px;
            width: 290px;
        }

        #loginbtn {
            text-align: center;
        }
    </style>
</head>
<body id="login">
<div id="wrappertop">
</div>
<div id="wrapper">
    <div id="content">
        <div id="header">
            <h1>
                <a href="">
                    <img src="${pageContext.request.contextPath}/resource/images/logo2.png" height="50" width="200"
                         alt="logo"></a></h1>
        </div>
        <div id="darkbanner" class="banner320">
            <h2>
                Login System</h2>
        </div>
        <div id="darkbannerwrap">
        </div>
        <form name="form1" method="post" action="index.php">
            <fieldset class="form">
                <p>
                    <label class="loginlabel" for="user_name">
                        Username:</label>
                    <input class="logininput ui-keyboard-input ui-widget-content ui-corner-all" name="userName"
                           id="user_name" type="text" value=""/>
                </p>

                <p>
                    <label class="loginlabel" for="user_password">
                        Password:</label>
                    <span>
                        <input class="logininput" name="password" id="user_password" type="password"/><img
                            id="passwd" class="tooltip" alt="Click to open the virtual keyboard"
                            title="Click to open the virtual keyboard"
                            src="${pageContext.request.contextPath}/resource/images/keyboard.png"/></span>
                </p>

                <p>
                    <label class="loginlabel" for="user_password">
                        Code:</label>
                    <span>
                        <img id="code" src="${pageContext.request.contextPath}/kaptcha/code.do"/></span>
                </p>
                <p class="loginlabel">
                    <button type="submit" style="width:290px">
                        Login
                    </button>
                </p>
            </fieldset>
    </div>
</div>
<div id="wrapperbottom_branding">
    <div id="wrapperbottom_branding_text">
        Language:<a href="#" style='text-decoration: none'>Japanese </a>| <a href="#" style='text-decoration: none'>
        English</a></div>
</div>
</body>
