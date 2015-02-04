<%@ page import="local.photoalbums.domain.Album" %>
<%--
  Created by IntelliJ IDEA.
  User: yar
  Date: 27.10.14
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Albums</h1>
<%Iterable<Album> albums = (Iterable<Album>) request.getAttribute("albums");%>
<%if(albums!=null){%>
<%for(Album album:albums){%>
    <a href="/album/<%out.print(album.getId());%>"><%out.print(album.getName());%></a>
<%}%>
<%}%>
<br/>
<a href="/admin/">Admin</a>
</body>
</html>
