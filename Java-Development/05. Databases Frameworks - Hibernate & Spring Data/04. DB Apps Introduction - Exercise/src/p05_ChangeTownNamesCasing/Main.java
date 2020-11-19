package p05_ChangeTownNamesCasing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

        String countryName = scanner.nextLine();
        if (!checkIfEntityExists(connection, countryName)){
            System.out.println("No town names are affected.");
            return;
        }

        List<String> towns = changeTownNameCasing(connection, countryName);

        System.out.println(String.format("%d town names are affected.", towns.size()));
        System.out.println(String.join(", ", towns));
    }

    private static boolean checkIfEntityExists(Connection connection, String countryName) throws SQLException {
        String query = String.format("SELECT * FROM towns WHERE country = '%s'", countryName);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()){
            return true;
        }

        return false;
    }

    private static List<String> changeTownNameCasing(Connection connection, String countryName) throws SQLException {
        String query = String.format("UPDATE towns t\n" +
                "SET name = UPPER(name)\n" +
                "WHERE t.country = '%s'", countryName);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        preparedStatement.execute();


        String selectQuery = String.format("SELECT name FROM towns WHERE country = '%s'", countryName);
        PreparedStatement stmt =
                connection.prepareStatement(selectQuery);

        ResultSet rs = stmt.executeQuery();
        List<String> towns = new ArrayList<>();

        while (rs.next()){
            towns.add(rs.getString(1));
        }

        return towns;

    }
}
