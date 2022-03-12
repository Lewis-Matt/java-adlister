import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: Create a page that displays a number that goes up by one every time the /count page is viewed.
//  Allow the user to pass a parameter in the query string to reset the counter.

@WebServlet(name = "PageViewServlet", urlPatterns = "/count")
public class PageViewServlet extends HttpServlet {
    private Integer viewCount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // .getParameter(Sting) the string can be anything, usually 'q' if it is a search query.
        String query =req.getParameter("count");
        viewCount++;
        // If the user doesn't enter anything
        if(query == null) {
            res.getWriter().write("Total Page Views: " + viewCount);
        } else {
            viewCount = Integer.valueOf(query);
            res.getWriter().write("Page Views Reset To: " + viewCount);
        }
    }
}
