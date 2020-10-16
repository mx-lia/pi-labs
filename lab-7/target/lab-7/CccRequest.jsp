<%--
  Created by IntelliJ IDEA.
  User: Yulya
  Date: 28.09.2020
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="attr.CBean" %>
<html>
<head>
    <title>CccRequest</title>
</head>
<body>
<%
    CBean cBean = (CBean) request.getAttribute("atrCBean");
    if(cBean!=null){
        String value1 = cBean.getValue1();
        String value2 = cBean.getValue2();
        String value3 = cBean.getValue3();
        out.write(
                "<br>Value1: " + value1 +
                        "<br>Value2: " + value2 +
                        "<br>Value3: " + value3
        );
    }
    else {
        out.write("CBean is null");
    }
%>
</body>
</html>
