package filter;

import model.User;
import storage.InMemoryUserStorage;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(servletNames = {"AuthorizationServlet", "RegistrationServlet"})
public class AccountFilter extends HttpFilter {

    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("user") == null) {
            if (req.getMethod().equals("POST")) {
                String name = req.getParameter("name");
                String login = req.getParameter("login");
                String password = req.getParameter("password");
                if (name == null) {
                    User user = inMemoryUserStorage.getByLogin(login);
                    if (user != null && user.getPassword().equals(password)) {
                        chain.doFilter(req, res);
                    } else {
                        req.setAttribute("message", "Incorrect login or password");
                        req.getServletContext().getRequestDispatcher("/auth.jsp").forward(req, res);
                    }
                } else {
                    Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.\\S+$)(.{3,})$");
                    Matcher matcher = pattern.matcher(name);
                    if (matcher.matches()) {
                        req.setAttribute("oldName", name);
                        if (login.matches("\\w{4,}")) {
                            req.setAttribute("oldLogin", login);
                            if (password.matches("\\S{4,}")) {
                                chain.doFilter(req, res);
                            } else {
                                req.setAttribute("message", "Incorrect password");
                                req.getServletContext().getRequestDispatcher("/reg.jsp").forward(req, res);
                            }
                        } else {
                            req.setAttribute("oldPassword", password);
                            req.setAttribute("message", "Incorrect login");
                            req.getServletContext().getRequestDispatcher("/reg.jsp").forward(req, res);
                        }
                    } else {
                        req.setAttribute("oldLogin", login);
                        req.setAttribute("oldPassword", password);
                        req.setAttribute("message", "Incorrect name");
                        req.getServletContext().getRequestDispatcher("/reg.jsp").forward(req, res);
                    }
                }
            } else {
                chain.doFilter(req, res);
            }
        } else {
            res.sendRedirect("/");
        }
    }
}
