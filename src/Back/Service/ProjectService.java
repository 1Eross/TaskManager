package Back.Service;

import Back.CurrentUser;
import Back.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProjectService {
    private final static String PROJECT_TABLE = "task_manager.project";

    public static ArrayList<Project> getAll() {

        String sqlCode = "SELECT * FROM " + PROJECT_TABLE
                + " WHERE user_id = '"
                + CurrentUser.getId() + "'";
        ArrayList<Project> result = new ArrayList<>();

        try {

            Statement statement = Database.getStatement();
            ResultSet resultSet = statement.executeQuery(sqlCode);

            while (resultSet.next()) {

                Project temp = new Project();
                temp.setId(resultSet.getLong("id"));
                temp.setTitle(resultSet.getString("title"));
                temp.setUser_id(CurrentUser.getId());

                result.add(temp);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static Project get(Project project){

        String sqlCode = "SELECT * FROM " + PROJECT_TABLE
                + " WHERE user_id = '" + CurrentUser.getId()
                + "' AND title = '" + project.getTitle() + "'";
        Project temp = new Project();

        try {

            Statement statement = Database.getStatement();
            ResultSet resultSet = statement.executeQuery(sqlCode);

            if (resultSet.next()) {

                temp.setTitle(project.getTitle());
                temp.setId(resultSet.getLong("id"));
                temp.setUser_id(CurrentUser.getId());

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return temp;
    }

    public static void set(Project project) {

        String sqlCode = "INSERT INTO " + PROJECT_TABLE + " (title, user_id)"
                + "VALUES ('" + project.getTitle() + "'::Text, '" + project.getUser_id() + "'::bigint)"
                + "RETURNING id";
        try {

            Statement statement = Database.getStatement();

            statement.executeQuery(sqlCode);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }
}
