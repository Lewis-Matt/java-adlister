import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PickColorServlet", urlPatterns = "/pickcolor")
public class PickColorServlet extends HttpServlet {
    // Takes us to the url to pick a color
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pickcolor.jsp").forward(request, response);
    }
    // The user enters their color, and when they 'subumit' we are redirected to viewcolor wtih the value of the name="color" input as the parameter sent with the post request.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("color");
        request.setAttribute("color", color);
        response.sendRedirect("/viewcolor?color=" + color);
    }
}
/*A user goes to /pickcolor and sees a page where they are prompted to enter their favorite color (using a text input). Upon clicking submit, they are redirected to /viewcolor and see a page with a background color of the submitted color.

    use a POST request on the form
    use two JSPs and two servlets
    use style tags to set the background color on the HTML body
    pass the data from one servlet to another by adding the color value in a query string
*/