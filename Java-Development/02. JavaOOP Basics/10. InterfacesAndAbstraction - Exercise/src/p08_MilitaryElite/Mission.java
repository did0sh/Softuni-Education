package p08_MilitaryElite;

public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }

    public void CompleteMission(){
        this.state = "Finished";
    }

    public String getCodeName() {
        return this.codeName;
    }

    public String getState() {
        return this.state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Code Name: %s State: %s%n", this.getCodeName(), this.getState()));
        return sb.toString();
    }
}
