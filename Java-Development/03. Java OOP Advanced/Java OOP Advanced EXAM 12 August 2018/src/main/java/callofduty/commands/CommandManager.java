package callofduty.commands;

import callofduty.core.MissionControlImpl;
import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;
import callofduty.domain.missions.EscortMission;
import callofduty.domain.missions.HuntMission;
import callofduty.domain.missions.SurveillanceMission;
import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CommandManager implements MissionManager {
    private Map<String, Agent> agentMap;
    private MissionControlImpl missionControl;

    private LinkedHashMap<String, Mission> assignedMissionMap;
    private LinkedHashMap<String, Mission> completedMissionMap;
    private LinkedHashMap<String, Mission> allMissions;

    private Map<String, Double> bounties;

    public CommandManager() {
        this.agentMap = new LinkedHashMap<>();
        this.missionControl = new MissionControlImpl();

        this.assignedMissionMap = new LinkedHashMap<>();
        this.completedMissionMap = new LinkedHashMap<>();
        this.allMissions = new LinkedHashMap<>();

        this.bounties = new LinkedHashMap<>();
    }

    @Override
    public String agent(List<String> arguments) {
        String id = arguments.get(1);
        String name = arguments.get(2);
        Agent agent = new NoviceAgent(id, name, 0.0);
        this.agentMap.put(id, agent);
        return String.format("Registered Agent - %s:%s", name, id);
    }

    @Override
    public String request(List<String> arguments) {
        String agentId = arguments.get(1);
        String missionId = arguments.get(2);
        Double missionRating = Double.parseDouble(arguments.get(3));
        Double missionBounty = Double.parseDouble(arguments.get(4));

        Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);
        this.agentMap.get(agentId).acceptMission(mission);

        this.assignedMissionMap.put(mission.getId(), mission);
        this.allMissions.put(mission.getId(), mission);

        if (mission instanceof EscortMission) {
            return String.format("Assigned Escort Mission - %s to Agent - %s", missionId,
                    this.agentMap.get(agentId).getName());
        } else if (mission instanceof HuntMission) {
            return String.format("Assigned Hunt Mission - %s to Agent - %s", missionId,
                    this.agentMap.get(agentId).getName());
        } else if (mission instanceof SurveillanceMission) {
            return String.format("Assigned Surveillance Mission - %s to Agent - %s", missionId,
                    this.agentMap.get(agentId).getName());
        }
        return null;
    }

    @Override
    public String complete(List<String> arguments) {
        String agentId = arguments.get(1);
        this.agentMap.get(agentId).completeMissions();


        for (Map.Entry<String, Mission> stringMissionEntry : this.assignedMissionMap.entrySet()) {
            this.completedMissionMap.put(stringMissionEntry.getKey(), stringMissionEntry.getValue());
        }

        this.assignedMissionMap = new LinkedHashMap<>();// TODO;

        return String.format("Agent - %s:%s has completed all assigned missions.",
                this.agentMap.get(agentId).getName(), agentId);
    }

    @Override
    public String status(List<String> arguments) {
        String id = arguments.get(1);
        if (this.agentMap.containsKey(id)) {
            Agent agent = this.agentMap.get(id);
            if (agent instanceof MasterAgent){
                StringBuilder sb = new StringBuilder(agent.toString());
                sb.append(String.format("Assigned Missions: %d", this.assignedMissionMap.size())).append(System.lineSeparator())
                        .append(String.format("Completed Missions: %d", this.completedMissionMap.size())).append(System.lineSeparator())
                        .append(String.format("Rating: %.2f%n", this.completedMissionMap.values().stream().mapToDouble(Mission::getRating).sum()))
                        .append(String.format("Bounty Earned: $%.2f%n",
                                this.completedMissionMap.values().stream().mapToDouble(Mission::getBounty).sum()));

                this.bounties.put(agent.getId(), this.completedMissionMap.values().stream().mapToDouble(Mission::getBounty).sum());
                return sb.toString().trim();
            } else {
                if (this.completedMissionMap.size() >= 3) {
                    agent = new MasterAgent(agent.getId(), agent.getName(), agent.getRating());
                    this.agentMap.put(agent.getId(), agent);
                    StringBuilder sb = new StringBuilder(agent.toString());

                    this.bounties.put(agent.getId(), 0.0);
                    sb.append(String.format("Assigned Missions: %d", this.assignedMissionMap.size())).append(System.lineSeparator())
                            .append(String.format("Completed Missions: %d", this.completedMissionMap.size())).append(System.lineSeparator())
                            .append(String.format("Rating: %.2f%n", this.completedMissionMap.values().stream().mapToDouble(Mission::getRating).sum()))
                            .append(String.format("Bounty Earned: $0.00%n"));

                    return sb.toString().trim();

                } else {
                    StringBuilder sb = new StringBuilder(agent.toString());
                    sb.append(String.format("Assigned Missions: %d", this.assignedMissionMap.size())).append(System.lineSeparator())
                            .append(String.format("Completed Missions: %d", this.completedMissionMap.size())).append(System.lineSeparator())
                            .append(String.format("Rating: %.2f%n", this.completedMissionMap.values().stream().mapToDouble(Mission::getRating).sum()));
                    return sb.toString().trim();
                }
            }

        }

        if (this.allMissions.containsKey(id)) {
            return this.allMissions.get(id).toString();
        }

        return null;
    }

    @Override
    public String over(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        int assignedMissionsCount = 0;
        int completedMissionsCount = 0;

        for (Mission value : this.allMissions.values()) {
            assignedMissionsCount++;
        }

        for (Mission value : this.completedMissionMap.values()) {
            completedMissionsCount++;
        }

        double totalRating = this.completedMissionMap.values().stream().mapToDouble(Mission::getRating).sum();
        double totalBounty = this.bounties.values().stream().mapToDouble(Double::valueOf).sum();

        sb.append(String.format("Novice Agents: %d%n", this.agentMap.values().stream().filter(agent ->
                agent.getClass().getSimpleName().equals("NoviceAgent")).collect(Collectors.toList()).size()))
                .append(String.format("Master Agents: %d%n", this.agentMap.values().stream().filter(agent ->
                        agent.getClass().getSimpleName().equals("MasterAgent")).collect(Collectors.toList()).size()))
                .append(String.format("Assigned Missions: %d%n", this.allMissions.size()))
                .append(String.format("Completed Missions: %d%n", this.completedMissionMap.size()))
                .append(String.format("Total Rating Given: %.2f%n", totalRating))
                .append(String.format("Total Bounty Given: $%.2f%n", totalBounty));
        return sb.toString().trim();
    }
}
