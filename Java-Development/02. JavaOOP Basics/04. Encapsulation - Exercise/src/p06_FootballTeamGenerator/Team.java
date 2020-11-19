package p06_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private static final String INVALID_NAME_MESSAGE = "A name should not be empty.";
    private String name;
    private double rating;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    public void updatePlayers(List<Player> players){
        this.players.clear();
        this.players = players;
    }

    public double calcTotalTeamRating(){
        double average = 0;
        if (this.players.size() > 0){
            for (Player player : players) {
                average += player.calcOverallSkill();
            }
            return average / this.players.size();
        }

        return 0;
    }
}
