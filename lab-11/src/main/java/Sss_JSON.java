import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(urlPatterns = "/Sss_JSON")
public class Sss_JSON extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Sss:doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.currentThread().sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Sss:doPost");
        Integer n = new Integer(req.getHeader("XRand-N"));
        XXRand num = new XXRand(n);
        resp.setContentType("application/json");
        PrintWriter w = resp.getWriter();
        String s ="{\"X\":[" ;
        for (int i = 0; i < 10; i++)
        {
            s += ("{\"rand\":"+ num.Get().toString()+"}"+
                    ((i < 9)?",":" "));
        }
        s+="]}";
        w.println(s);
    }

    public class XXRand {
        private Integer n = Integer.MAX_VALUE;
        private Random random = new Random();

        public XXRand(Integer n) {
            if (n > 0)
                this.n = n;
        }

        public Integer Get() {
            return (this.random.nextInt()%this.n);
        }
    }
}
