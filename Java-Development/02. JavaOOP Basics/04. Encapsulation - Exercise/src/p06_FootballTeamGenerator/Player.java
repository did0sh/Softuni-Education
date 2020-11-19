package p06_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private static final String INVALID_NAME_MESSAGE = "A name should not be empty.";
    private static final String INVALID_STAT_MESSAGE = "%s should be between 0 and 100.";
    private static final List<String> STATS_NAMES = new ArrayList() {{
        add("Endurance");
        add("Sprint");
        add("Dribble");
        add("Passing");
        add("Shooting");
    }};

    private int countOnWhichStat = 0;
    private String name;
    private LinkedHashMap<String, Integer> stats;

    public Player(String name) {
        this.setName(name);
        this.stats = new LinkedHashMap<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.name = name;
    }

    public void addStat(Integer statOverall) {
        if (statOverall < 0 || statOverall > 100){
            throw new IllegalArgumentException(String.format(INVALID_STAT_MESSAGE, STATS_NAMES.get(this.countOnWhichStat)));
        }
        this.stats.put(STATS_NAMES.get(this.countOnWhichStat), statOverall);
        this.countOnWhichStat++;
    }

    public double calcOverallSkill(){
        double average = 0;
        if (this.stats.size() > 0){
            for (Map.Entry<String, Integer> entry : stats.entrySet()) {
                average += entry.getValue();
            }
            return average / this.stats.size();
        }
       return 0;
    }

    public String getName() {
        return this.name;
    }
}
