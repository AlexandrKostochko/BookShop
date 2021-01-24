package servlet;

import model.Author;
import storage.InMemoryAuthorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authors/author")
public class AuthorServlet extends HttpServlet {

    private InMemoryAuthorStorage inMemoryAuthorStorage = InMemoryAuthorStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Author author = inMemoryAuthorStorage.getById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("author", author);
        req.getServletContext().getRequestDispatcher("/author.jsp").forward(req, resp);
    }
}
