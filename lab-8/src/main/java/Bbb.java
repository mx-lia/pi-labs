import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/Bbb")
public class Bbb extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        PrintWriter pw = response.getWriter();
        pw.println("<h2>Headers from Servlet Aaa: </h2>");

        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            pw.println(key + ": " + value);
        }

        pw.println("<h2>Query params from Servlet Aaa: </h2>");
        pw.println("param1: " + request.getParameter("param1"));
        pw.println("param2: " + request.getParameter("param2"));
        pw.println("param3: " + request.getParameter("param3"));

        response.setHeader("x-resp-header-1", "1");
        response.setHeader("x-resp-header-2", "2");
    }
}