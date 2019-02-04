import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PageCount", urlPatterns = "/count")
public class PageCount extends HttpServlet {
    int counter = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        counter+=1;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Page Views: " + counter + "</h2>");

    }
}