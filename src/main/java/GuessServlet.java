import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {
    // Loads/Gets guess.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/guess.jsp").forward(request, response);
    }
    // This happens when the form is submitted
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Random number 1 - 3
        int random = (int) Math.ceil(Math.random() * 3);
        // From guess.jsp form ("name" field), string parsed to integer
        int userGuess = Integer.parseInt(request.getParameter("guess"));
        if (userGuess != 1 && userGuess != 2 && userGuess != 3) {
            response.sendRedirect("/guess");
        } else if (userGuess != random) {
            response.sendRedirect("/correct");
        } else {
            response.sendRedirect("/incorrect");
        }
    }
}
/*A user goes to /guess and is prompted to guess a number between 1 and 3. If correct, the user will be redirected to /correct or /incorrect, depending on if they guess correctly. In either case, the user will see the same view but with an outcome-specific message in a heading (e.g. "You Won!" or "You Lose!").

    use a POST request on the form
    use two JSPs (one for guessing and another to view the outcome)
    use three servlets:
        one servlet for sending the guess view and processing the guess
        another servlet for serving up the outcome JSP with a win message
        another servlet for serving up the outcome JSP with a loss message

Bonus: If a user submits a number other than 1, 2, or 3, redirect them back to the guessing form.*/