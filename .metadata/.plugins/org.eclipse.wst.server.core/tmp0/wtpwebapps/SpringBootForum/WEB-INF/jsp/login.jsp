<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.forum.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
      <link rel="stylesheet" type="text/css" href="/css/styleLogin.css">
   </head>
   <body>
         <form action=""  method="post">
            <div class="header">
               <h2>Đăng nhập</h2>
            </div>
            <div class="content">
                <div class="row">
                    <div class="row-left"> <p class="row-item">Tên đăng nhập</p> <p class="row-item">Mật khẩu</p></div>

                    <div class="row-right"> <input type="text" name="username"> <input type="text" name="password"></div>

                </div>
                <input id="submit" type="submit" value="Đăng nhập">
                <c:if test="${check != null}">
                    <p style="color: red;">${check}</p>
                </c:if>
            </div>
         </form>
      
   </body>
</html>
