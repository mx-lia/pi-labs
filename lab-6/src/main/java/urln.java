import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

@WebServlet(name = "urln", urlPatterns = "/url")
public class urln extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String param = req.getParameter("urln");

        PrintWriter printWriter = resp.getWriter();

        if (param.equals("1")) {
            HttpClient hc = new HttpClient();
            GetMethod gm = new GetMethod(getServletContext().getInitParameter("URL1"));
            hc.executeMethod(gm);

            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();
            pw.println(gm.getResponseBodyAsString());
            pw.flush();
        } else if (param.equals("2")) {
            HttpClient hc = new HttpClient();
            GetMethod gm = new GetMethod(getServletContext().getInitParameter("URL2"));
            hc.executeMethod(gm);

            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();
            pw.println(gm.getResponseBodyAsString());
            pw.flush();
        } else{
            printWriter.println("parameter URLn not found");
        }

    }
}