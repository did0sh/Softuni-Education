package p02_GetVillainsNames;

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

        PreparedStatement stmt =
                connection.prepareStatement("SELECT v.name, COUNT(mv.minion_id) AS `minions_count`\n" +
                "FROM minions_villains mv\n" +
                "JOIN villains v\n" +
                "ON v.id = mv.villain_id\n" +
                "GROUP BY v.name\n" +
                "HAVING minions_count > ?\n" +
                "ORDER BY `minions_count` DESC;");

        System.out.print("Enter minions more than: ");
        int minionsCount = Integer.parseInt(scanner.nextLine());

        stmt.setInt(1, minionsCount);
        ResultSet rs = stmt.executeQuery();
        List<String> resultSetList = new ArrayList<>();

        while (rs.next()){
            resultSetList.add(String.format("%s %d%n",
                    rs.getString("v.name"), rs.getInt("minions_count")));
        }

        resultSetList.forEach(System.out::print);
    }
}
