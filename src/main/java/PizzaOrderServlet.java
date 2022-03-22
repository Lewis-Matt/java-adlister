import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
// Servlets should only handle logic (meaning no HTML inside of strings inside of servlets), and JSPs should just deal with presentation (meaning no arbitrary java inside of <% %>)
// A user goes to /pizza-order and sees a pizza order form. This form features choices to select the crust type, sauce type, size type (use select inputs), toppings (checkboxes), and delivery address (text input).
// Use System.out.println to output the values submitted by the user.
//    use a POST request on the form
//    use one JSP and one servlet
//    don't worry about styling
@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
