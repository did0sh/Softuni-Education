package p07_PrintAllMinionsNames;

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

        printMinionsInCustomOrder(connection);

    }

    private static void printMinionsInCustomOrder(Connection connection) throws SQLException {
        String query = "SELECT name FROM minions";
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        List<String> names = new ArrayList<>();

        while (rs.next()){
            names.add(rs.getString(1));
        }

        for (int i = 1; i <= names.size() / 2 ; i++) {
            System.out.println(names.get(i-1));
            System.out.println(names.get(names.size() - i));
        }
    }
}
