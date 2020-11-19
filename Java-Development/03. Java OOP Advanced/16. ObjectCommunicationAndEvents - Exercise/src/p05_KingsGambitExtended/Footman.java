package p05_KingsGambitExtended;

public class Footman extends AbstractModel implements Killable {
    private int hits;
    public Footman(String name) {
        super(name);
        this.hits = 0;
    }

    @Override
    public void updateHits() {
        this.hits++;
    }

    public int getHits() {
        return this.hits;
    }
}
