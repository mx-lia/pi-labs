import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

@WebServlet(name = "Sss", urlPatterns = "/Sss")
public class Sss extends HttpServlet {

    public Sss() {
        super();
        System.out.println("Sss:constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Sss:init");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Sss:destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("Sss:service");

        RequestDispatcher requestDispatcher = null;
        String _click = req.getParameter("click");
        PrintWriter printWriter = resp.getWriter();

        if (_click == null) {
            printWriter.println("Sss:doGet");
        } else {

            if (_click.equalsIgnoreCase("value")) {
                resp.sendRedirect("Ggg");
            }

            if (_click.equalsIgnoreCase("value1")) {
                printWriter.println("Sss:POST in service");
            }

            if (_click.equalsIgnoreCase("value2")) {
                resp.sendRedirect("Ggg?param2=testvalue");
                printWriter.println("<br/>POST Sss -> Ggg");
            }

            if (_click.equalsIgnoreCase("value3")) {
                resp.sendRedirect("redirect.html");
            }

            if (_click.equalsIgnoreCase("value4")) {
                requestDispatcher = req.getRequestDispatcher("Ggg");
                requestDispatcher.forward(req, resp);
            }

            if(_click.equalsIgnoreCase("value5")){
                requestDispatcher = req.getRequestDispatcher("Ggg");
                requestDispatcher.forward(req, resp);
            }

            if(_click.equalsIgnoreCase("value6")) {
                HttpClient hc = new HttpClient();
                GetMethod gm = new GetMethod("http://localhost:8081/lab_3_war_exploded/Ggg?click=value6&p1=Yuliya&p2=Maximchikova");
                hc.executeMethod(gm);

                resp.setContentType("text/html");
                PrintWriter pw = resp.getWriter();
                pw.println(gm.getResponseBodyAsString());
                pw.flush();
            }

            if(_click.equalsIgnoreCase("value7")) {
                HttpClient hc1 = new HttpClient();
                PostMethod pm = new PostMethod("http://localhost:8081/lab_3_war_exploded/Ggg?click=example&p1=Yuliya&p2=Maximchikova");
                hc1.executeMethod(pm);
                resp.setContentType("text/html");
                PrintWriter pw = resp.getWriter();
                pw.println(pm.getResponseBodyAsString());
                pw.flush();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doGet(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("Sss:doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("Sss:doPost");
    }
}