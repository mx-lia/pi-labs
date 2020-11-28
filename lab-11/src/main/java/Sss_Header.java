import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Sss_Header")
public class Sss_Header extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Sss:doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.currentThread().sleep(10000);  // 10 sec
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Sss:doPost");
        System.out.println(req.getHeader("Value-X"));
        System.out.println(req.getHeader("Value-Y"));
        Float x = new Float(req.getHeader("Value-X"));
        Float y = new Float(req.getHeader("Value-Y"));
        Float z = x + y;
        System.out.println(z.toString());
        resp.setHeader("Value-Z", z.toString());
    }
}
