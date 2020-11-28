import utils.ChoiceXXX;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/Sss")
public class Sss extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Servlet:SSS");
        String fileName = request.getParameter("file");
        String docdir = getServletContext().getInitParameter("doc-dir");
        File file = new File(docdir, fileName);

        ChoiceXXX.outputDoc(file, response);
    }
}