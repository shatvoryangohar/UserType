package servlet;

import manager.UserManager;
import model.User;
import model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserManager userManager = new UserManager();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmail = req.getParameter("email");
        String userPassword = req.getParameter("password");

        if (userEmail == null && userPassword == null) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        User user = userManager.login(userEmail, userPassword);

        if (user.getId() == 0) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", user);
            UserType type = user.getType();
            if (type.equals(UserType.MANAGER)) {
                req.getRequestDispatcher("/manager.jsp").forward(req, resp);
            } else if (type.equals(UserType.USER)) {
                resp.sendRedirect("/user-home");
            }
        }
    }
}
