import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
// Servlets should only handle logic (meaning no HTML inside of strings inside of servlets), and JSPs should just deal with presentation (meaning no arbitrary java inside of <% %>)
// A user goes to /pizza-order and sees a pizza order form. This form features choices to select the crust type, sauce type, size type (use select inputs), toppings (checkboxes), and delivery address (text input).
// Use System.out.println to output the values submitted by the user.
//    use a POST request on the form
//    use one JSP and one servlet
//    don't worry about styling

@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
    // This method allows us to pass the flow of control from our servlet to a JSP. The string that is passed to the method should be the path to the JSP file relative to the webapp directory.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/pizza.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Returns the value of a request parameter as a String, or null if the parameter does not exist.
        String crust = request.getParameter("crust");
        String sauce = request.getParameter("sauce");
        String size = request.getParameter("size");
        // Returns an array of String objects containing all the values the given request parameter has, or null if the parameter does not exist.
        String[] toppings = request.getParameterValues("toppings");

        System.out.println(crust);
        System.out.println(sauce);
        System.out.println(size);
        System.out.println(Arrays.toString(toppings));
    }
}
