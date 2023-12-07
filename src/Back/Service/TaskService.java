package Back.Service;

import Back.CurrentUser;
import Back.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TaskService {

    private final static String TASK_TABLE = "task_manager.task";

    public static ArrayList<Task> getAll(Long assignment_id, Long project_id) {
        String sqlCode = "SELECT * FROM " + TASK_TABLE
                + " WHERE user_id = '" + CurrentUser.getId()
                + "' AND project_id  = '" + project_id
                + "' AND assigment_id = '" + assignment_id + "'";
        ArrayList<Task> result = new ArrayList<>();


        try {

            Statement statement = Database.getStatement();
            ResultSet resultSet = statement.executeQuery(sqlCode);

            while (resultSet.next()) {

                Task temp = new Task();
                temp.setId(resultSet.getInt("id"));
                temp.setTitle(resultSet.getString("title"));
                temp.setDescription(resultSet.getString("description"));
                temp.setPriority(resultSet.getInt("priority"));
                temp.setTaskDate(resultSet.getLong("task_date"));
                temp.setStatus(resultSet.getBoolean("status"));
                temp.setAssignmentId(assignment_id);
                temp.setProjectId(project_id);
                temp.setUser_id(CurrentUser.getId());

                result.add(temp);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static Task get(Task task) {

        String sqlCode = "SELECT * FROM " + TASK_TABLE
                + " WHERE user_id = '" + CurrentUser.getId()
                + "' AND title = '" + task.getTitle()
                + "' AND project_id  = '" + task.getProjectId()
                + "' AND assigment_id = '" + task.getAssignmentId() + "'";

        Task result = new Task();

        try {

            Statement statement = Database.getStatement();
            ResultSet resultSet = statement.executeQuery(sqlCode);

            if (resultSet.next()) {

                result.setId(resultSet.getInt("id"));
                result.setTitle(resultSet.getString("title"));
                result.setDescription(resultSet.getString("description"));
                result.setPriority(resultSet.getInt("priority"));
                result.setTaskDate(resultSet.getLong("task_date"));
                result.setStatus(resultSet.getBoolean("status"));
                result.setAssignmentId(task.getAssignmentId());
                result.setProjectId(task.getProjectId());
                result.setUser_id(CurrentUser.getId());

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static long set(Task task) {

        String setSqlCode = "INSERT INTO " + TASK_TABLE + " (title, description, assigment_id, project_id, user_id)"
                + "VALUES ('" + task.getTitle() + "'::Text, '" + task.getDescription() + "'::Text, '"
                + task.getAssignmentId() + "'::bigint, '" + task.getProjectId() + "'::bigint, '" + task.getUser_id() + "'::bigint)"
                + "RETURNING id";
        long returningId = -1;

        try {


            //Setting new statement
            Statement statement = Database.getStatement();
            ResultSet resultSet =  statement.executeQuery(setSqlCode);

            if (resultSet.next()){
                returningId = resultSet.getLong("id");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return returningId;
    }

    public static void update (Task task) {

        String sqlCode = "UPDATE " + TASK_TABLE
                + " SET title = '" + task.getTitle() + "',"
                + "description = '" + task.getDescription() + "',"
/*                + "priority = '" + task.getPriority() + "',"
                + "task_date = '" + task.getTaskDate() + "',"
                + "status = '" + task.getStatus() + "',"*/
                + "assigment_id = '" + task.getAssignmentId() + "',"
                + "project_id = '" + task.getProjectId() + "',"
                + "user_id = '" + task.getUser_id() + "'"
                + "WHERE id = '" + task.getId() + "';";

        try {

            Statement statement = Database.getStatement();
            statement.executeQuery(sqlCode);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
