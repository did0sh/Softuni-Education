package p03_GetMinionNames;

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
                connection.prepareStatement("SELECT m.name, m.age, v.name \n" +
                        "FROM minions_villains mv\n" +
                        "JOIN minions m\n" +
                        "ON m.id = mv.minion_id\n" +
                        "JOIN villains v\n" +
                        "ON v.id = mv.villain_id\n" +
                        "WHERE mv.villain_id = ?;");

        System.out.print("Villain id: ");
        int villainId = Integer.parseInt(scanner.nextLine());

        stmt.setInt(1, villainId);
        ResultSet rs = stmt.executeQuery();
        List<String> resultSetList = new ArrayList<>();

        int count = 0;
        while (rs.next()) {
            count++;
            if (count == 1){
                resultSetList.add(String.format("Villain: %s%n", rs.getString("v.name")));
            }
            resultSetList.add(String.format("%d. %s %d%n",
                    count,
                    rs.getString("m.name"),
                    rs.getInt("m.age")));
        }

        if (count == 0){
            System.out.println(String.format("No villain with id %d exists in the database.", villainId));
        }

        resultSetList.forEach(System.out::print);
    }
}
