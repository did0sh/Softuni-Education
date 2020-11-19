package p08_IncreaseMinionsAge;

import java.sql.*;
import java.util.*;

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

        int[] minionsIds = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        modifyMinions(connection, minionsIds);

        printAllMinions(connection);
    }

    private static void modifyMinions(Connection connection, int[] minionsIds) throws SQLException {
        for (int i = 0; i < minionsIds.length; i++) {
            String queryForIncreasingAge = "UPDATE minions\n" +
                    "SET age = age + 1\n" +
                    "WHERE id = ?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(queryForIncreasingAge);
            preparedStatement.setInt(1, minionsIds[i]);
            preparedStatement.execute();

            String queryForModifyingName = "UPDATE minions\n" +
                    "SET name = CONCAT(UPPER(SUBSTRING(name, 1, 1)), LOWER(SUBSTRING(name, 2)))\n" +
                    "WHERE id = ?";

            PreparedStatement stmt =
                    connection.prepareStatement(queryForModifyingName);
            stmt.setInt(1, minionsIds[i]);
            stmt.execute();
        }
    }

    private static void printAllMinions(Connection connection) throws SQLException {
        String query = "SELECT name, age FROM minions";
        PreparedStatement statement =
                connection.prepareStatement(query);

        ResultSet rs = statement.executeQuery();
        List<String> result = new ArrayList<>();

        while (rs.next()){
            result.add(String.format("%s %d", rs.getString(1), rs.getInt(2)));
        }

        result.forEach(System.out::println);
    }
}
