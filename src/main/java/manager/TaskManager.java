package manager;

import db.DBConnectionProvider;
import model.Task;
import model.TaskStatus;
import model.User;
import model.UserType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    Connection connection = DBConnectionProvider.getInsert().getConnection();


    public void addTask(Task task) {
        String sql = "Insert into task(name,description,status,deadline,user_id)Values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, task.getName());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus().name());
            ps.setDate(4, task.getDeadLine());
            ps.setInt(5, task.getUserId());
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                task.setId(anInt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getAllTask() {
        String sql = "Select *  from task";
        List<Task> tasks = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setStatus(TaskStatus.valueOf(resultSet.getString("status")));
                task.setDeadLine(resultSet.getDate("deadline"));
                task.setUserId(resultSet.getInt("user_id"));
                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> getAllTaskByUserId(int userId) {
        String sql = "Select * from task where user_id = " + userId;
        List<Task> tasks = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setStatus(TaskStatus.valueOf(resultSet.getString("type")));
                task.setDeadLine(resultSet.getDate("deadline"));
                task.setUserId(resultSet.getInt("user_id"));
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
