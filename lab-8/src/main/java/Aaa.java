import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/Aaa")
public class Aaa extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String inputLine;
        PrintWriter pw = response.getWriter();
        URL obj = new URL("http://localhost:8081//lab_8_war_exploded/Bbb");
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("x-header-1", "1");
        httpURLConnection.setRequestProperty("x-header-2", "2");
        httpURLConnection.setRequestProperty("x-header-3", "3");
        String urlParameters = "param1=1&param2=2&param3=3";

        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(10000);

        DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        pw.println("Response Code: " + httpURLConnection.getResponseCode());
        pw.println();
        pw.println("Response:");

        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

        while ((inputLine = in.readLine()) != null) pw.println(inputLine);

        Map<String, List<String>> headerNames = httpURLConnection.getHeaderFields();

        pw.println();
        pw.println("Response Headers (Servlet Aaa):");

        for (Map.Entry<String, List<String>> header : headerNames.entrySet()) {
            pw.println(header.getKey() + ": " + header.getValue());
        }

        in.close();
    }
}