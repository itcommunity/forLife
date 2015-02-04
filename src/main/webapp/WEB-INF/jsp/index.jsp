<%@ page import="local.photoalbums.model.Cat" %>
<%--
  Created by IntelliJ IDEA.
  User: yar
  Date: 21.10.14
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<%Cat cat = (Cat) request.getAttribute("cat");
String message = (String)request.getAttribute("message");
if(message==null) message="";%>
<body>
<jsp:include page="top.jsp"/>
<h1>Cat name: <%out.print(cat.getName());%></h1>
<h2><%out.print(message);%></h2>
<jsp:include page="fileUpload.jsp"/>
<jsp:include page="simpleForm.jsp"/>
<jsp:include page="bottom.jsp"/>
</body>
</html>
