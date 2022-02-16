package servlet;

import manager.TaskManager;
import model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allTask")
public class AllTaskServlet extends HttpServlet {
    private TaskManager manager = new TaskManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> allTask = manager.getAllTask();
        req.setAttribute("allTasks", allTask);
        req.getRequestDispatcher("/allTasks.jsp").forward(req, resp);
    }
}
