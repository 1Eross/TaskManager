package Back.Service;

import Back.Assignment;
import Back.CurrentUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AssignmentService {
    private final static String ASSIGNMENT_TABLE = "task_manager.assigment";

    public static ArrayList<Assignment> getAll(Long project_id) {

        String sqlCode = "SELECT * FROM " + ASSIGNMENT_TABLE
                + " WHERE user_id = '" + CurrentUser.getId()
                + "' AND project_id = '" + project_id + "'";
        ArrayList<Assignment> result = new ArrayList<>();

        try {

            Statement statement = Database.getStatement();
            ResultSet resultSet = statement.executeQuery(sqlCode);

            while (resultSet.next()) {

                Assignment temp = new Assignment();
                temp.setId(resultSet.getLong("id"));
                temp.setTitle(resultSet.getString("title"));
                temp.setProject_id(resultSet.getLong("project_id"));
                temp.setUser_id(CurrentUser.getId());

                result.add(temp);

            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static Assignment get(Assignment assignment) {

        String sqlCode = "SELECT * FROM " + ASSIGNMENT_TABLE
                + " WHERE user_id = '" + CurrentUser.getId()
                + "' AND project_id = '" + assignment.getProject_id()
                + "' AND title = '" + assignment.getTitle() + "'";
        Assignment temp = new Assignment();

        try {

            Statement statement = Database.getStatement();
            ResultSet resultSet = statement.executeQuery(sqlCode);

            if (resultSet.next()) {

                temp.setId(resultSet.getLong("id"));
                temp.setTitle(resultSet.getString("title"));
                temp.setProject_id(resultSet.getLong("project_id"));
                temp.setUser_id(CurrentUser.getId());

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return temp;
    }

    public static long set(Assignment assignment){

        String sqlCode = "INSERT INTO " + ASSIGNMENT_TABLE + " (title, project_id, user_id)"
                + "VALUES ('" + assignment.getTitle() +"'::Text, '"
                + assignment.getProject_id() +"'::bigint, '" + assignment.getUser_id() + "'::bigint)"
                + "RETURNING id";
        long returningId = -1;

        try {

            Statement statement = Database.getStatement();
            ResultSet resultSet = statement.executeQuery(sqlCode);

            if (resultSet.next()){

                returningId = resultSet.getLong("id");

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return returningId;

    }

}
