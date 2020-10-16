<%--
  Created by IntelliJ IDEA.
  User: Yulya
  Date: 28.09.2020
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cntatrr.CBean" %>
<html>
<head>
    <title>Ccc</title>
</head>
<body>
<%
    ServletContext servletContext = application;
    System.out.println("jsp: " + servletContext.getAttribute("atrCBean") + "\n");
    CBean cBean = (CBean) servletContext.getAttribute("atrCBean");
    if (cBean != null)
    {
        String value1 = cBean.getValue1();
        String value2 = cBean.getValue2();
        String value3 = cBean.getValue3();
        out.println(
                "<br>Value1: " + value1 +
                        "<br>Value2: " + value2 +
                        "<br>Value3: " + value3
        );
    }
    else
    {
        out.write("CBean is null");
    }
%>
</body>
</html>
