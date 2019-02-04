import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    int counter = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        counter+=1;
        String queryString = request.getParameter("name");
        if(queryString != null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Hello, " + queryString + "!</h1>");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Hello, World!"+ "</h1>");
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h5>Total page Views: " + counter + "</h5>");


    }
}
