package servlet;

import model.User;
import storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user/findAll", name = "FindAllServlet")
public class FindAllServlet extends HttpServlet {

    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> getAll = inMemoryUserStorage.getAllUsers();
        req.setAttribute("users", getAll);
        req.getServletContext().getRequestDispatcher("/findAll.jsp").forward(req, resp);
    }
}
