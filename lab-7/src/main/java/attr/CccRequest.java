package attr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/CccRequest")
public class CccRequest extends HttpServlet {
    public CBean cBean;

    @Override
    public void init() throws ServletException {
        cBean = new CBean();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("goGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("CBean") != null && req.getParameter("CBean").equals("new")) {
            cBean = new CBean();
            req.setAttribute("atrCBean", cBean);
            System.out.println("new: " + req.getAttribute("atrCBean"));
            System.out.println();
        } else if (req.getParameter("CBean").equals("old")){
            System.out.println("old: " + req.getAttribute("atrCBean"));
            System.out.println();
        }

        String param1 = req.getParameter("value1"),
                param2 = req.getParameter("value2"),
                param3 = req.getParameter("value3");

        if (param1 != null && param2 != null && param3 != null) {
            cBean.setValue1(param1);
            cBean.setValue2(param2);
            cBean.setValue3(param3);
        }

        req.getRequestDispatcher("/CccRequest.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}