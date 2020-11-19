package callofduty.domain.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.lang.reflect.Field;
import java.util.Map;

public class NoviceAgent extends AbstractAgent {
    public NoviceAgent(String id, String name, Double rating) {
        super(id, name, 0.0);
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int assignedMissionsCount = 0;
        int completedMissionsCount = 0;
        try {
            Class<Agent> agentClass = (Class<Agent>) Class.forName("callofduty.domain.agents.AbstractAgent");
            Field missionMapField = agentClass.getDeclaredField("assignedMissionMap");
            missionMapField.setAccessible(true);

            Map<String, Mission> map = (Map<String, Mission>) missionMapField.get(this);
            for (Mission value : map.values()) {
                assignedMissionsCount++;
            }

            Class<?> agClass = Class.forName("callofduty.domain.agents.AbstractAgent");
            Field completed = agentClass.getDeclaredField("completedMissionMap");
            completed.setAccessible(true);

            Map<String, Mission> completedMap = (Map<String, Mission>) completed.get(this);
            for (Mission value : completedMap.values()) {
                completedMissionsCount++;
            }

        } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }



        sb.append(String.format("Novice Agent - %s", super.getName())).append(System.lineSeparator())
                .append(String.format("Personal Code: %s", super.getId())).append(System.lineSeparator());
        return sb.toString();
    }
}
