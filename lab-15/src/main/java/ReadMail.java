import lombok.SneakyThrows;

import javax.mail.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet("/ReadMail")
public class ReadMail extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Session session = Session.getDefaultInstance(new Properties());
            Store store = session.getStore("imaps");
            store.connect(getServletContext().getInitParameter("mailHostInbox"),
                    Integer.parseInt(getServletContext().getInitParameter("mailPortInbox")),
                    getServletContext().getInitParameter("mailUsername"),
                    getServletContext().getInitParameter("mailPassword"));
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            response.setContentType("text/html;charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            for (Message message : messages) {
                printWriter.println("<h3>Message: " + message.getContent() + "</h3>");
            }

            printWriter.flush();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
