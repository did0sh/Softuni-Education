package callofduty.domain.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractAgent implements Agent {
    private String id;
    private String name;
    private Double rating;
    private LinkedHashMap<String,Mission> assignedMissionMap;
    private LinkedHashMap<String,Mission> completedMissionMap;
    private LinkedHashMap<String, Mission> allMissions;

    protected AbstractAgent(String id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.assignedMissionMap = new LinkedHashMap<>();
        this.completedMissionMap = new LinkedHashMap<>();
        this.allMissions = new LinkedHashMap<>();
    }

    @Override
    public void acceptMission(Mission mission) {
        this.assignedMissionMap.put(mission.getId(), mission);
        this.allMissions.put(mission.getId(), mission);
    }

    @Override
    public void completeMissions() {
        for (Map.Entry<String, Mission> stringMissionEntry : assignedMissionMap.entrySet()) {
            this.completedMissionMap.put(stringMissionEntry.getKey(), stringMissionEntry.getValue());
        }
        this.assignedMissionMap = new LinkedHashMap<>();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }
}
