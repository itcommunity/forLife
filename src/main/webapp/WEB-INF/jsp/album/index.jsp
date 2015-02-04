<%@ page import="local.photoalbums.domain.Album" %>
<%@ page import="local.photoalbums.domain.Photo" %>
<%--
  Created by IntelliJ IDEA.
  User: yar
  Date: 25.10.14
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%
    Album album = (Album) request.getAttribute("album");
    int counter = 0;
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file="../top.jsp" %>
<%if (album != null) {%>
<h1><%out.print(album.getName());%></h1>
<%if (album.getPhotos().size() > 0) {%>
<table>
    <%for (Photo photo : album.getPhotos()) {%>
    <%if (counter == 0) {%>
    <tr>
        <td><img src='/static/photo/<%out.print(photo.getId());%>' width="300" height="300"></td>
        <%counter++;%>
        <%} else if (counter < 4) {%>
        <td><img src='/static/photo/<%out.print(photo.getId());%>' width="300" height="300"></td>
        <%counter++;%>
        <%} else {%>
        <td><img src='/static/photo/<%out.print(photo.getId());%>' width="300" height="300"></td>
    </tr>
    <%counter = 0;%>
    <%}%>
    <%}%>
</table>
<%}%>
<%}%>
<a href="/admin/">Admin</a>
<%@include file="../bottom.jsp"%>
</body>
</html>
