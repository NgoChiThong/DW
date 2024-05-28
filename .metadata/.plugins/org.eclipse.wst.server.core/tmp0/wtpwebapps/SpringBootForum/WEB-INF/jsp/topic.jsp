<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
      <link rel="stylesheet" type="text/css" href="/css/styleTopic.css">
   </head>
   <body>
        <header>
            <div class="header">
                <p>Chào user | </p> <a href="/logout">Thoát</a>
            </div>
        </header>
        <div class="container">
            <h2>Chủ đề: ${topic.title}</h2>
            <p>Bài mới nhất gửi

                <c:if test="${ empty topic.messages}">
                    ${topic.createdTime}
                </c:if>
                <c:if test="${not empty topic.messages}">
                    ${topic.messages.get(0).createdTime}
                </c:if>
                , do <b>
                    <c:if test="${ empty topic.messages}">
                        ${topic.creator.username}
                    </c:if>
                    <c:if test="${not empty topic.messages}">
                        ${topic.messages.get(0).creator.username}
                    </c:if>
            </b> gửi. ${topic.messages.size()} hồi âm.</p>

            <div class="content">
                <div class="content-date"> ${topic.createdTime}</div>
                <div class="row">
                    <div class="row-left">
                        <b>${topic.creator.username}</b>
                        <p>Tham gia ${topic.creator.joinDate}</p>
                    </div>
                    <div class="row-right">
                        <div class="top">
                            <div class="top-left">${topic.title}</div>

                            <div class="top-right"><a href="/replyTopic?id=${topic.id}">Trả Lời</a> </div>
                        </div>
                            <div class="bottom">${topic.content}</div>
                    </div>
                </div>
            </div>
            <c:if test="${not empty topic.messages}">
                <c:forEach var="item" items="${topic.messages}">
                    <div class="content">
                        <div class="content-date">${item.createdTime}</div>
                        <div class="row">
                            <div class="row-left">
                                <b>${item.creator.username}</b>
                                <p>Tham gia ${item.creator.joinDate}</p>
                            </div>
                            <div class="row-right">
                                <div class="top">
                                    <div class="top-left">${item.title}</div>

                                    <div class="top-right"><a href="/replyTopic?id=${topic.id}">Trả lời</a> </div>
                                </div>
                                <div class="bottom">${item.content}</div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>


        </div>

        <footer>
            <div class="footer">
                <a href="/listTopic">Danh sách chủ đề</a>
            </div>
        </footer>
   </body>
</html>
