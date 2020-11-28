<%@ page contentType="text/html" %>
<%@ page import="utils.ChoiceXXX" %>
<%
    String d = request.getServletContext().getInitParameter("doc-dir");
    ChoiceXXX ch = new ChoiceXXX(d, "doc");
    String ll = "";
    for (int i = 0; i < ch.listxxx.length; ++i) {
        ll = ch.listxxx[i];
%>
<br>
<a href="Sss?file=<%=ll%>"><%=ll%>
</a>
<%}%>

<form method="POST" action="Bbb" enctype="multipart/form-data" >
    File:
    <input type="file" name="file" id="file" /> <br/>
    </br>
    <input type="submit" value="Upload" name="upload" id="upload" />
</form>
