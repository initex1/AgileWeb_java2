package lv.console.database.jdbc;

import lv.console.database.TaskRepository;
import lv.console.domain.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class TaskRepositoryImpl extends JDBCRepository implements TaskRepository {
    @Override
    public void addTask(Task task) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into TASKS(id, taskTitle) values(default, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, task.getTaskTitle());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                task.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute .addTask()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean deleteTask(Task task) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "delete from TASKS where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, task.getId());
            int numOfRowsDeleted = preparedStatement.executeUpdate();
            return numOfRowsDeleted == 1;
        } catch (Throwable e) {
            System.out.println("Exception while execute .deleteTask()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }


    @Override
    public Optional<Task> findTaskByTitle(String taskTitle) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from tasks where taskTitle = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, taskTitle);
            ResultSet resultSet = preparedStatement.executeQuery();
            Task task = null;
            if (resultSet.next()) {
                task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setTaskTitle(resultSet.getString("taskTitle"));
            }
            return Optional.ofNullable(task);
        } catch (Throwable e) {
            System.out.println("Exception while execute .findTaskByTitle()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> products = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from tasks";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setTaskTitle(resultSet.getString("taskTitle"));
                products.add(task);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting user list .getAll()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
        return products;
    }


}
