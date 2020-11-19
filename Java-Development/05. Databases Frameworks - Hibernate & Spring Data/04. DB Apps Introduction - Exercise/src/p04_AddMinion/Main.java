package p04_AddMinion;

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

        String[] minionInfo = scanner.nextLine().split("\\s+");
        String[] villainInfo = scanner.nextLine().split("\\s+");

        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String townName = minionInfo[3];
        String villainName = villainInfo[1];

        if (!checkIfTownExists(connection, townName)){
            System.out.println(insertTown(connection, townName));
        }

        if (!checkIfVillainExists(connection, villainName)){
            System.out.println(insertVillain(connection, villainName));
        }

        int townId = getEntityId(connection, "towns", townName);

        insertMinion(connection, minionName, townId, minionAge, villainName);

        int minionId = getEntityId(connection, "minions", minionName);
        int villainId = getEntityId(connection, "villains", villainName);

        hireMinionToBeServant(connection, minionId, villainId);

        System.out.println(String.format("Successfully added %s to be minion of %s.", minionName, villainName));

    }

    private static boolean checkIfTownExists(Connection connection, String townName) throws SQLException {
        String query = String.format("SELECT * FROM towns WHERE name = '%s'", townName);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            return true;
        }
        return false;
    }

    private static String insertTown(Connection connection, String townName) throws SQLException {
        String query = String.format("INSERT INTO towns(name, country) VALUES('%s', %s)", townName, null);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        preparedStatement.execute();
        return String.format("Town %s was added to the database.", townName);
    }

    private static boolean checkIfVillainExists(Connection connection, String villainName) throws SQLException {
        String query = String.format("SELECT * FROM villains WHERE name = '%s'", villainName);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            return true;
        }
        return false;
    }

    private static String insertVillain(Connection connection, String villainName) throws SQLException {
        String query = String.format("INSERT INTO villains(name, evilness_factor) VALUES('%s', 'evil')", villainName);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        preparedStatement.execute();
        return String.format("Villain %s was added to the database.", villainName);
    }

    private static int getEntityId(Connection connection, String tableName, String name) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = '%s'",
                tableName, name);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    private static void insertMinion(Connection connection, String minionName, int townId, int age, String villainName) throws SQLException {
        String query = String.format("INSERT INTO minions(name, age, town_id) VALUES('%s', '%d', '%d')",
                minionName, age, townId);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        preparedStatement.execute();
    }

    private static void hireMinionToBeServant(Connection connection, int minionId, int villainId) throws SQLException {
        String query = String.format("INSERT INTO minions_villains(minion_id, villain_id) VALUES('%d', '%d')",
                minionId, villainId);
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        preparedStatement.execute();
    }
}
