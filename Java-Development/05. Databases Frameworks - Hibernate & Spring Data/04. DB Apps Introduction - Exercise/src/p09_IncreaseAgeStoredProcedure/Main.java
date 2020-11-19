package p09_IncreaseAgeStoredProcedure;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username default (root): ");
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.print("Enter password default (empty): ");
        String password = scanner.nextLine();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        int minionId = Integer.parseInt(scanner.nextLine());

        callStoredProcedure(connection, minionId);

        printMinions(connection, minionId);
    }

    private static void callStoredProcedure(Connection connection, int minionId) throws SQLException {
        String query = "CALL usp_get_older (?)";
        CallableStatement statement =
                connection.prepareCall(query);

        statement.setInt("minion_id", minionId);
        statement.execute();
    }

    private static void printMinions(Connection connection, int minionId) throws SQLException {
        String query = "SELECT name, age FROM minions WHERE id = ?";
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        preparedStatement.setInt(1, minionId);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        System.out.println(String.format(("%s %d"), rs.getString(1), rs.getInt(2)));
    }
}
