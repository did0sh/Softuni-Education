package p10_Mood3;

public class Demon extends GameObjects {
    public double specialPoints;
    private String hashPassword;

    public Demon(String username, int level, double specialPoints) {
        super(username, level);
        this.specialPoints = specialPoints;
        this.setHashPassword();
    }

    public double getSpecialPoints() {
        return this.specialPoints;
    }

    protected void setHashPassword() {
       this.hashPassword = String.valueOf(super.getUsername().length() * 217);
    }

    @Override
    public String getHashPassword() {
        return this.hashPassword;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\"%s\" | \"%s\" -> %s%n", super.getUsername(),
                this.getHashPassword(), this.getClass().getSimpleName()));
        sb.append(String.format("%.1f%n", this.getSpecialPoints() * this.getLevel()));
        return sb.toString();
    }
}
