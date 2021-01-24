package servlet;


import model.User;
import storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private  InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(name, login, password);
        boolean save = inMemoryUserStorage.reg(login);
        if (save) {
            inMemoryUserStorage.save(user);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("message", "user is exists");
            req.setAttribute("oldName", name);
            req.setAttribute("oldLogin", login);
            req.setAttribute("oldPassword", password);
            req.getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
        }
    }
}
