import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DbConnector", urlPatterns = "/database")
public class DbConnector extends HttpServlet {

    private  Connection connection;
    private  String url = "jdbc:jtds:sqlserver://./students;instance=LOCALDB#5A2C229F;namedPipe=true;";
    private static String driverName = "net.sourceforge.jtds.jdbc.Driver";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url);
            System.out.println(connection.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Statement stmt=null;
        try{
            try{
                Integer id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                stmt = connection.createStatement();
                String query = String.format("call insertToT1(%d, '%s')", id, name);
                ResultSet rs=stmt.executeQuery(query);
                response.getWriter().println("done");
            } catch(SQLException s){
                s.printStackTrace();
                response.getWriter()
                        .println(s.getMessage());
            }

            stmt.close();
        }catch (Exception e){
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            response.getWriter()
                    .println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Integer id = 0;
        String name = "";
        String query;

        query = "SELECT * FROM t1";

        if(request.getParameter("id")!=null){
            id=Integer.parseInt(request.getParameter("id"));
            query = String.format("SELECT * FROM t1 WHERE id=%d", id);
        }

        if(request.getParameter("name")!=null){
            name = request.getParameter("name");
            query = String.format("SELECT * FROM t1 WHERE name='%s'", name);
        }

        if(request.getParameter("name")!=null && request.getParameter("id")!=null){
            query = String.format("SELECT * FROM t1 WHERE id='%d' and name='%s'", id, name);
        }


        Statement stmt=null;
        try{
            try{
                stmt = connection.createStatement();
                ResultSet rs=stmt.executeQuery(query);

                StringBuilder resultMessage = new StringBuilder();
                while(rs.next()){
                    resultMessage
                            .append("<div>")
                            .append(rs.getInt("id")).append("   ").append(rs.getString("name"))
                            .append("</div>");
                }
                // close ResultSet rs
                rs.close();
                System.out.println(resultMessage);
                response.getWriter().println(resultMessage);
            } catch(SQLException s){
                s.printStackTrace();
                response.getWriter()
                        .println(s.getMessage());
            }

            stmt.close();
        }catch (Exception e){
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            response.getWriter()
                    .println(e.getMessage());
        }*/
    }

    @Override
    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}