import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// TODO: Create a page that displays "Hello World!" when a user visits /hello
//  Make the page say "Hello, <name>!" if name is passed as part of the query string (e.g. /hello?name=codeup), otherwise default to "Hello, World!".
// WebServlet annotation. This allows us to specify what URL this servlet should handle. http://localhost:8080/hello
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    @Override
    // GET, handle request, handle response
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Set the content type of the request.
        res.setContentType("text/html");
        // Get a reference to a PrintWriter object (and add IOException to signature)
        PrintWriter out = res.getWriter();
        // Store search query
        // Even though  servlet can receive parameters in a number of different ways, every servlet retrieves its parameters the same way, using getParameter() and getParameterValues()
        // getParameter() returns the value of the named parameter as a String or null if the parameter was not specified.
        String query = req.getParameter("name");
        // Use that object to send some HTML as a response.
        if (query == null) {
            out.println("<h1>Hello, World!</h1>");
        } else {
            out.printf("<h1>Hello, %s!</h1>%n", query);
        }
    }
}
