<%--
  Created by IntelliJ IDEA.
  User: yar
  Date: 27.10.14
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/static/css/elements.css" rel="stylesheet">
    <script src="/static/js/uploadForm.js"></script>
    <script src="/static/js/addAlbumForm.js"></script>
    <script src="/static/js/showPhoto.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <title></title>
</head>
<body id="body" style="overflow:hidden;">
<div id="full_body">
    <div class=""
    <div class="navbar navbar-default">
        <%@include file="../top.jsp" %>
    </div>
    <div id="top_panel">
        <%@include file="top_panel.jsp"%>
    </div>
    <div id="left_panel">
        <%@include file="left_panel.jsp" %>
    </div>
    <div id="centre">
        <%@include file="albums.jsp" %>
    </div>
    <%--<div id="bottom">--%>
    <%--<%@include file="../bottom.jsp" %>--%>
    <%--</div>--%>
    <%@include file="../photo/showPhoto.jsp" %>
    <%@include file="uploadFilePopup.jsp" %>
    <%@include file="addAlbumPopup.jsp" %>
</div>
</body>
</html>
