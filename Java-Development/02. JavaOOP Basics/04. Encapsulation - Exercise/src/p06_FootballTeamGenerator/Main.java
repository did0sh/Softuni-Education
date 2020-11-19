package p06_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<String, Team> allTeams = new LinkedHashMap<>();

        while (!"end".equalsIgnoreCase(input)) {
            String[] info = input.split(";");
            String command = info[0];
            switch (command) {

                case "Team":
                    String teamName = info[1];
                    Team team = null;
                    try {
                        team = new Team(teamName);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                        break;
                    }

                    allTeams.put(teamName, team);
                    break;

                case "Add":
                    boolean playerToAdd = true;
                    String teamToAdd = info[1];
                    if (!allTeams.containsKey(teamToAdd)) {
                        System.out.printf("Team %s does not exist.%n", teamToAdd);
                        break;
                    } else {
                        String playerName = info[2];
                        Player player = null;
                        try {
                            player = new Player(playerName);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                            playerToAdd = false;
                            break;
                        }

                        for (int i = 3; i < info.length; i++) {
                            try {
                                player.addStat(Integer.parseInt(info[i]));
                            } catch (IllegalArgumentException iae) {
                                System.out.println(iae.getMessage());
                                playerToAdd = false;
                            }
                        }

                        if (playerToAdd) {
                            allTeams.get(teamToAdd).addPlayer(player);
                        }
                    }
                    break;
                case "Remove":
                    String teamToSearch = info[1];
                    String playerName = info[2];

                    if (allTeams.get(teamToSearch).getPlayers()
                            .stream()
                            .noneMatch(player -> player.getName().equals(playerName))) {
                        System.out.printf("Player %s is not in %s team.%n", playerName, teamToSearch);
                    } else {
                        List<Player> filteredPlayers = allTeams.get(teamToSearch).getPlayers()
                                .stream()
                                .filter(player -> !player.getName().equals(playerName)).collect(Collectors.toList());

                        allTeams.get(teamToSearch).updatePlayers(filteredPlayers);
                    }
                    break;
                case "Rating":
                    String existingTeam = info[1];
                    if (!allTeams.containsKey(existingTeam)) {
                        System.out.printf("Team %s does not exist.%n", existingTeam);
                    } else {
                        double rating = allTeams.get(existingTeam).calcTotalTeamRating();
                        System.out.printf("%s - %.0f%n", existingTeam, rating);
                    }
                    break;
            }
            input = reader.readLine();
        }
    }
}
