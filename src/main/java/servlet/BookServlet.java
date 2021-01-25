package servlet;

import model.Book;
import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authors/books/book")
public class BookServlet extends HttpServlet {

    private InMemoryBookStorage inMemoryBookStorage = InMemoryBookStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = inMemoryBookStorage.getById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("book", book);
        req.getServletContext().getRequestDispatcher("book.jsp").forward(req, resp);
    }
}
