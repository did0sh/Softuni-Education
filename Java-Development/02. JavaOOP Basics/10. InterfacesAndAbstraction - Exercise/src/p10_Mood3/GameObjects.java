package p10_Mood3;

public abstract class GameObjects {
    private String username;
    private String hashPassword;
    private int level;

    protected GameObjects(String username, int level) {
        this.username = username;
        this.level = level;
    }

    protected String getUsername() {
        return this.username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected String getHashPassword() {
        return this.hashPassword;
    }

    protected int getLevel() {
        return this.level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }
}
