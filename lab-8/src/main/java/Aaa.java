import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/Aaa")
public class Aaa extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpClient hc = new HttpClient();
        String uri = "http://localhost:8081//lab_8_war_exploded/Bbb";
        PostMethod pm = new PostMethod(uri);

        pm.addRequestHeader("x-header-1", "1");
        pm.addRequestHeader("x-header-2", "2");
        pm.addRequestHeader("x-header-3", "3");

        pm.addParameter("param1", "1");
        pm.addParameter("param2", "2");
        pm.addParameter("param3", "3");

        hc.executeMethod(pm);
        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();
        pw.println(pm.getResponseBodyAsString());

        Header[] headerNames = pm.getResponseHeaders();
        pw.println("<h2>Headers from Servlet Bbb: </h2>");
        for (Header header:
             headerNames) {
            pw.println(header.getName() + ": " + header.getValue());
        }

        NameValuePair[] params = pm.getParameters();
        pw.println("<h2>Params from Servlet Bbb: </h2>");

        for (NameValuePair param:
                params) {
            pw.println(param.getName() + ": " + param.getValue());
        }
    }
}