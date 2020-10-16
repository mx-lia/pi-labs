package cntatrr;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Ccc")
public class Ccc extends HttpServlet {
    public CBean cBean = null;

    @Override
    public void init() throws ServletException {
        cBean = new CBean();

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("atrCBean", cBean);
        System.out.println("init " +servletContext.getAttribute("atrCBean"));
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
        if (req.getParameter("CBean").equals("new")) {
            cBean = new CBean();
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute("atrCBean", cBean);
            System.out.println("new: " + servletContext.getAttribute("atrCBean"));

            String param1 = req.getParameter("value1"),
                    param2 = req.getParameter("value2"),
                    param3 = req.getParameter("value3");


            if (param1 != null && param2 != null && param3 != null) {
                cBean.setValue1(param1);
                cBean.setValue2(param2);
                cBean.setValue3(param3);

                req.getRequestDispatcher("/Ccc.jsp").forward(req, resp);
            }
        } else if (req.getParameter("CBean").equals("old")){ //if "old"
            ServletContext servletContext = getServletContext();
            System.out.println("old: " + servletContext.getAttribute("atrCBean"));
            req.getRequestDispatcher("/Ccc.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}