<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
      <link rel="stylesheet" type="text/css" href="/css/styleTopics.css">
   </head>
   <body>
        <header>
            <div class="header">
                <p>Chào <c:out value="${sessionScope.user.username}"/>| </p> <a href="/logout">Thoát</a>
            </div>
        </header>
        <div class="container">
            <h3>Diễn đàn: Chuyện học phí và các chính sách hỗ trợ học tập</h3>
            <button  class="ui-button"><a href="/newTopic"> Gửi bài mới </a></button>


            <table>
                <tr>
                    <th style="width: 90%;">Chủ đề</th>
                    <th style="width: 10%;">Hồi âm</th>
                </tr>
                <c:forEach var="item" items="${topic}">
                    <tr>
                        <td class="content-table">
                            <a href="/topic?id=${item.id}"> ${item.title} </a>
                            <p>bài mới nhất by <a href="#">
                                <c:if test="${ empty item.messages}">
                                    ${item.creator.username}
                                </c:if>
                                <c:if test="${not empty item.messages}">
                                    ${item.messages.get(0).creator.username}
                                </c:if>
                            </a>, ${item.createdTime}</p>
                        </td>
                        <td style="text-align: center;">${item.messages.size()}</td>
                    </tr>

                </c:forEach>

            </table>
        </div>

   </body>
</html>
