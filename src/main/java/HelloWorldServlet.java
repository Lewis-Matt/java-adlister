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
        // Even though  servlet can receive parameters in a number of different ways, every servlet retrieves its parameters the same way, using getParameter() and getParameterValues() - see notes in codeup-java-exercises
        // getParameter() returns the value of the named parameter as a String or null if the parameter was not specified.
        String query = req.getParameter("name");
        // Use the 'out' object to send HTML as a response.
        if (query == null) {
            // Default
            out.println("<h1>Hello, World!</h1>");
        } else {
            // Passed in username
            out.printf("<h1>Hello, %s!</h1>%n", query);
        }
    }
}
// Run the server. It will open browser to http://localhost:8080, which is a 404 because I didn't create a main page
// USE:
// http://localhost:8080/hello?name=Matt  OR
// http://localhost:8080/count