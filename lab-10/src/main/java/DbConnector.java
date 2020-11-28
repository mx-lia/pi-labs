import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DbConnector", urlPatterns = "/database")
public class DbConnector extends HttpServlet {
    private String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS:1434;database=schooldb;username=Yuliya;password=Pa$$w0rd";
    private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            String sql = "select * from student where total_score >= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(request.getParameter("totalScore")));
            ResultSet rss = stm.executeQuery();
            pw.println("<table border='1'>");
            pw.println("<tr><td>ID</td><td>Name</td><td>Gender</td><td>Age</td><td>Total score</td></tr>");
            while (rss.next()) {
                pw.println("<tr>"
                        + "<td>" + rss.getString(1) + "</td>"
                        + "<td>" + rss.getString(2) + "</td>"
                        + "<td>" + rss.getString(3) + "</td>"
                        + "<td>" + rss.getString(4) + "</td>"
                        + "<td>" + rss.getString(5) + "</td>"
                        + "</tr>");
            }
            pw.println("</table>");
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException:" + e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            String sql = "{call GetStudentName (?, ?)}";
            CallableStatement stm = connection.prepareCall(sql);
            stm.setInt(1, Integer.parseInt(request.getParameter("studentId")));
            stm.registerOutParameter(2, Types.VARCHAR);
            stm.execute();
            pw.println("Student name: " + stm.getString("studentName"));
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException:" + e);
        }
    }

    @Override
    public void destroy() {
    }
}