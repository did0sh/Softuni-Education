package p04_FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeamPlayers;
    private List<Person> reserveTeamPlayers;

    public Team(String name) {
        this.name = name;
        this.firstTeamPlayers = new ArrayList<>();
        this.reserveTeamPlayers = new ArrayList<>();
    }

    public List<Person> getFirstTeamPlayers() {
        return Collections.unmodifiableList(this.firstTeamPlayers);
    }

    public List<Person> getReserveTeamPlayers() {
        return Collections.unmodifiableList(this.reserveTeamPlayers);
    }


    public void addPlayer(Person person){
        if (person.getAge() < 40){
            this.firstTeamPlayers.add(person);
        } else {
            this.reserveTeamPlayers.add(person);
        }
    }

    @Override
    public String toString() {
        return String.format("First team have %d players%nReserve team have %d players",
                this.firstTeamPlayers.size(), this.reserveTeamPlayers.size());
    }
}
