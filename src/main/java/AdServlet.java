
import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.List;

@WebServlet(name="AdsServlet", urlPatterns = "/ads")
public class AdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get all the quotes
        Ads ads = DaoFactory.getAdsDao();

        // bind the ads to the request object
        request.setAttribute("ads", ads.all());

        // send the response along w/ the data
        request.getRequestDispatcher("WEB-INF/ads/index.jsp").forward(request, response);
    }
}