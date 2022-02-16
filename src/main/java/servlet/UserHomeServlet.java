package servlet;

import manager.TaskManager;
import manager.UserManager;
import model.Task;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user-home")
public class UserHomeServlet  extends HttpServlet {

    private TaskManager taskManager = new TaskManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Task> taskList = taskManager.getAllTaskByUserId(user.getId());
        req.setAttribute("allTasks", taskList);

        req.getRequestDispatcher("/allTasks.jsp").forward(req,res);
    }
}
