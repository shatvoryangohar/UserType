package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allUsers")
public class AllUsersServlet extends HttpServlet {
  private   UserManager manager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = manager.getAllUsers();
        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher("/allUsers.jsp").forward(req,resp);
    }
}
