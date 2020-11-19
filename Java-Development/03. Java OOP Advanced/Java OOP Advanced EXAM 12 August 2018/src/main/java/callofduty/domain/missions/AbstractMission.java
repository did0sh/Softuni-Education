package callofduty.domain.missions;

import callofduty.interfaces.Mission;

public abstract class AbstractMission implements Mission {
    private String id;
    private Double rating;
    private Double bounty;
    private String status;

    protected AbstractMission(String id, Double rating, Double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
        this.status = "Open";
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = this.getClass().getSimpleName().indexOf("M");
        String className = this.getClass().getSimpleName().substring(0, index);
        sb.append(String.format("%s Mission - %s", className, this.getId())).append(System.lineSeparator())
                .append(String.format("Status: %s", this.status)).append(System.lineSeparator())
                .append(String.format("Rating: %.2f", this.getRating())).append(System.lineSeparator())
                .append(String.format("Bounty: %.2f", this.getBounty())).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
