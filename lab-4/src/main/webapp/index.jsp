<%@ page import="jsp.TimeHelper" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<html>
<head>
    <title>lab-4</title>
</head>
<body>

<%TimeHelper timeHelper = new TimeHelper();%>
<%timeHelper.PrintHello(timeHelper.getHour());%>
<h1><%=timeHelper.getRc()%></h1>

<%
    Calendar calendar = Calendar.getInstance();
    int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
%>
<table id="tbl" border="1"></table>

<div style="margin: 10px 0px;">
    <a href="Jjj">GET</a>
</div>
<div style="margin: 10px 0px;">
    <form action="Jjj" method="post">
        <input type="submit" name="press" value="PRESS">
    </form>
</div>

<%--<%@ include file="afternoon.jsp" %>--%>
<jsp:include page="afternoon.jsp"></jsp:include>
<%--<jsp:forward page="afternoon.jsp"></jsp:forward>--%>
<div style="margin: 10px 0px;">
    <a href="Afternoon">AFTERNOON</a>
</div>

<script>
    function createTable() {
        <%
          StringBuilder htmlValue = new StringBuilder();
          String wDay = "";
          htmlValue
              .append("<tr>")
              .append("<th>").append("DAY OF WEEK").append("</th>")
              .append("<th>").append("DATE").append("</th>")
              .append("</tr>");
          for (int i = 0; i < 7; i++) {
            int day = 24*60*60*1000*i;
            switch (weekDay) {
                case 1: wDay = "sunday"; break;
                case 2: wDay = "monday"; break;
                case 3: wDay = "tuesday"; break;
                case 4: wDay = "wednesday"; break;
                case 5: wDay = "thursday"; break;
                case 6: wDay = "friday"; break;
                case 7: wDay = "saturday"; break;
            }
            htmlValue
              .append("<tr>")
              .append("<td>").append(wDay).append("</td>")
              .append("<td>").append(dateFormat.format(new Date(calendar.getTimeInMillis() + day))).append("</td>")
              .append("</tr>");
            weekDay = (weekDay % 7) + 1;
          }
        %>
        document.getElementById("tbl").innerHTML = "<%= htmlValue %>";
    }
    createTable();
</script>
</body>
</html>
