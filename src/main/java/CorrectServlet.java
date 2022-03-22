import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CorrectServlet", urlPatterns = "/correct")
public class CorrectServlet extends HttpServlet {
    // This servlet has no HTML, just processes some Java and forwards the response to outcome.jsp, hence a Get and not a Post
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correct = "Correct";
        request.setAttribute("message", correct);
//        response.sendRedirect("/outcome");
        request.getRequestDispatcher("/outcome.jsp").forward(request, response);
    }
}
