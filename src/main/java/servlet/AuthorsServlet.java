package servlet;

import storage.InMemoryAuthorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authors")
public class AuthorsServlet extends HttpServlet {

    private InMemoryAuthorStorage inMemoryAuthorStorage = InMemoryAuthorStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("authors", inMemoryAuthorStorage.getAllAuthors());
        req.getServletContext().getRequestDispatcher("/authors.jsp").forward(req, resp);
    }
}
