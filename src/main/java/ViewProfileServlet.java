import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // User is not logged in, send to login. This stops the user from just typing in /profile, there must be something in the 'user' variable to check against.
        if (request.getSession().getAttribute("user") == null) {
            // Note: this sends the redirect to the page (url). Has nothing to do with the path to the file in WEB-INF
            response.sendRedirect("/login");
            return;
        }
        // User is logged in, send to profile
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
