package p10_Mood3;

public class Archangel extends GameObjects {
    private int specialPoints;
    private String hashPassword;

    public Archangel(String username, int level, int specialPoints) {
        super(username, level);
        this.specialPoints = specialPoints;
        this.setHashPassword();
    }

    public int getSpecialPoints() {
        return this.specialPoints;
    }

    protected void setHashPassword() {
        String reverse = new StringBuilder(new String(this.getUsername().toCharArray())).reverse().toString();
        this.hashPassword= String.format("%s%d", reverse, reverse.length() * 21);
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
        sb.append(String.format("%d%n", this.getSpecialPoints() * super.getLevel()));
        return sb.toString();
    }
}
