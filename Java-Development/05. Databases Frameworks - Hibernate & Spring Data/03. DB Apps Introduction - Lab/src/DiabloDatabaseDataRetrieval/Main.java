package DiabloDatabaseDataRetrieval;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter username default (root): ");

        String username = scan.nextLine().trim();
        username = username.equals("") ? "root" : username;

        System.out.print("Enter password default (empty): ");

        String password = scan.nextLine().trim();

        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement statement =
                connection.prepareStatement("SELECT u.user_name, " +
                        "concat_ws(' ', u.first_name, u.last_name) AS full_name, " +
                        "COUNT(ug.game_id) AS games_played\n" +
                        "FROM users u\n" +
                        "JOIN users_games ug\n" +
                        "ON u.id = ug.user_id\n" +
                        "WHERE u.user_name = ?\n" +
                        "GROUP BY u.id");

        String user = scan.nextLine();
        statement.setString(1, user);

        ResultSet rs = statement.executeQuery();
        List<String> list = new ArrayList<>();

        while (rs.next()){
            list.add(String.format("User: %s%n%s has played %d games", rs.getString("user_name"),
                    rs.getString("full_name"),
                    rs.getInt("games_played")));
        }

        if (list.size() == 0){
            System.out.println("No such user exists");
            return;
        }
        list.forEach(System.out::println);
    }
}
