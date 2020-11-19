package p04_MordorsCrueltyPlan;

public class Gandalf {
    private String mood;
    private int pointsOfHappiness;

        public void setPointsOfHappiness (String type) {
            switch (type.toLowerCase()) {
                case "cram":
                    this.pointsOfHappiness += 2;
                    break;
                case "lembas":
                    this.pointsOfHappiness += 3;
                    break;
                case "apple":
                    this.pointsOfHappiness += 1;
                    break;
                case "melon":
                    this.pointsOfHappiness += 1;
                    break;
                case "honeycake":
                    this.pointsOfHappiness += 5;
                    break;
                case "mushrooms":
                    this.pointsOfHappiness -= 10;
                    break;
                default:
                    this.pointsOfHappiness -= 1;
                    break;
            }
        }

        public int getPointsOfHappiness() {
            return this.pointsOfHappiness;
        }

    private String getMood(){
        if (this.getPointsOfHappiness() < -5){
            this.mood = "Angry";
        } else if (this.getPointsOfHappiness() < 0){
            this.mood = "Sad";
        } else if (this.getPointsOfHappiness() < 15){
            this.mood = "Happy";
        } else {
            this.mood = "JavaScript";
        }

        return this.mood;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getPointsOfHappiness())
                .append(System.lineSeparator())
                .append(this.getMood())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
