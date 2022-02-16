package servlet;

import lombok.SneakyThrows;
import manager.TaskManager;
import model.Task;
import model.TaskStatus;
import util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;


@WebServlet(urlPatterns = "/addTask")
public class TaskServlet extends HttpServlet {
    private TaskManager manager = new TaskManager();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        TaskStatus status = TaskStatus.valueOf(req.getParameter("status"));
        Date deadline = null;
        try {
            deadline = DateUtil.stringToDate(req.getParameter("deadline"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String idStr = req.getParameter("user_id");
        int id = Integer.parseInt(idStr);

        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setStatus(status);
        task.setDeadLine(deadline);
        task.setUserId(id);
        manager.addTask(task);

        resp.sendRedirect("/allTask");
    }
}
