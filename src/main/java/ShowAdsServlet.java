import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ads")
public class ShowAdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Use DAOFactory to get a DAO object
        Ads adsDao = DaoFactory.getAdsDao();
        // Use the all method
        List<Ad> ads = adsDao.all();
        // Pass data to JSP -'ads' is what the EL syntax will reference in the JSP
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
