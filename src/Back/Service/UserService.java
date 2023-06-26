package Back.Service;

import Back.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {

    private final static String USER_TABLE = "task_manager.user_data";
    public static int check(String login, String password) { //Сделано не очень
        String sqlCode = "SELECT * FROM " + USER_TABLE
                + " WHERE login = '" + login
                + "' AND user_password = '" + password + "'";
        int result = -1;

        try {

            Statement statement = Database.getStatement();
            ResultSet resultSet = statement.executeQuery(sqlCode);

            if (resultSet.next()) {
                result = resultSet.getInt("id");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static void set(User user) {

        String sqlCode = "INSERT INTO " + USER_TABLE + " (login, user_password)"
                + "VALUES ('" + user.getLogin() + "'::Text, '" + user.getPassword() + "'::Text)"
                + "RETURNING id";

        try {

            Statement statement = Database.getStatement();

            statement.executeQuery(sqlCode);

        } catch (SQLException e) {

            System.out.println(e.getMessage());


        }
    }

}
