package servlet;

import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authors/author")
public class AuthorServlet extends HttpServlet {

    private InMemoryBookStorage inMemoryBookStorage = InMemoryBookStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("author", inMemoryBookStorage.getByIdAuthor(Integer.parseInt(req.getParameter("id"))));
        req.getServletContext().getRequestDispatcher("/author.jsp").forward(req, resp);
    }
}
