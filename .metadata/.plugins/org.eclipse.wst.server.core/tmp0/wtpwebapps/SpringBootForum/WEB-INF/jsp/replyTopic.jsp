
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
      <link rel="stylesheet" type="text/css" href="/css/style.css">
   </head>
   <body>
        <header>
            <div class="header">
                <p>Chào user | </p> <a href="#">Thoát</a>
            </div>
        </header>
        <form action="/replyTopic"  method="post">
            <input type="text" name="id" hidden="hidden" value="${topic.id}">
            <br><br>
            <label for="topic">Tiêu đề</label><br>
            <input type="text" style="width: 80%;"  id="topic" name="title" value="RE: ${topic.title}"><br>
            <br><br>
            <label for="content">Nội dung</label><br>
            <input type="text" style="width: 100%; height: 100px;" id="content" name="contents" draggable="true" value="">
            <div class="row">
                <input id="submit" type="submit" value="Gởi">
                <button><a href="/listTopic">Hủy bỏ</a></button>
            </div>
        </form>
   </body>
</html>
