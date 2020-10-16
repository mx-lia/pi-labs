<%--
  Created by IntelliJ IDEA.
  User: Yulya
  Date: 28.09.2020
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.FileWriter" %>
<html>
<head>
    <title>Night</title>
</head>
<body>
<%
    BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Study\\Java\\lab-4\\src\\main\\logs\\stdout.txt", true));
    writer.write("Night");
    writer.append("\n");
    writer.close();
%>
<h1>Night</h1>
</body>
</html>
