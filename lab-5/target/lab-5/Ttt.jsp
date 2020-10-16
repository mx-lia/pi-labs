<%--
  Created by IntelliJ IDEA.
  User: Yulya
  Date: 28.09.2020
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="usrtlb" uri="usertaglib.tld" %>
<html>
<head>
    <title>Ttt: lab-5</title>
</head>
<body>
<usrtlb:dossier action="/Ttt">
    <usrtlb:firstname />
    <br/>
    <usrtlb:lastname />
    <br/>
    <usrtlb:sex />
    <br/>
    <usrtlb:submit />
</usrtlb:dossier>
</body>
</html>
