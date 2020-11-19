package p06_RemoveVillain;

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

        int villainId = Integer.parseInt(scanner.nextLine());

        if (!checkIfVillainExists(connection, villainId)){
            System.out.println("No such villain was found");
            return;
        }

        removeForeignKeysChecks(connection);
        System.out.println(deleteVillain(connection, villainId));
        System.out.println(deleteMinionsToCurrentVillain(connection, villainId));
    }

    private static boolean checkIfVillainExists(Connection connection, int villainId) throws SQLException {
        String queryToGetName = String.format("SELECT name FROM villains WHERE id = %d", villainId);
        PreparedStatement stmt =
                connection.prepareStatement(queryToGetName);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            return true;
        }

        return false;
    }

    private static void removeForeignKeysChecks(Connection connection) throws SQLException {
        String query = "SET FOREIGN_KEY_CHECKS=0;";
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        preparedStatement.execute();
    }

    private static String deleteVillain(Connection connection, int villainId) throws SQLException {
        String queryToGetName = String.format("SELECT name FROM villains WHERE id = %d", villainId);
        PreparedStatement stmt =
                connection.prepareStatement(queryToGetName);

        ResultSet rs = stmt.executeQuery();
        rs.next();
        String name = rs.getString(1);

        String query = String.format("DELETE FROM villains WHERE id = %d", villainId);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        preparedStatement.execute();

        return String.format("%s was deleted", name);
    }

    private static String deleteMinionsToCurrentVillain(Connection connection, int villainId) throws SQLException {
        String queryToGetCountMinions = String.format("SELECT COUNT(minion_id) AS counted_minions\n" +
                "FROM minions_villains\n" +
                "WHERE villain_id = %d\n" +
                "GROUP BY villain_id\n", villainId);
        PreparedStatement stmt =
                connection.prepareStatement(queryToGetCountMinions);

        int countMinions = 0;
        try {
            ResultSet rs = stmt.executeQuery();
            rs.next();
            countMinions = rs.getInt(1);
        }catch (SQLException ex){
            countMinions = 0;
        }


        String query = String.format("DELETE FROM minions_villains WHERE villain_id = %d", villainId);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        preparedStatement.execute();

        return String.format("%d minions released", countMinions);
    }
}
