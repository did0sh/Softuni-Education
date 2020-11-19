package hell.entities.heroes;

public class Assassin extends BaseHero {

    private static final Integer ASSASSIN_BASE_STRENGTH = 25;
    private static final Integer ASSASSIN_BASE_AGILITY = 100;
    private static final Integer ASSASSIN_BASE_INTELLIGENCE = 15;
    private static final Integer ASSASSIN_BASE_HITPOINTS = 150;
    private static final Integer ASSASSIN_BASE_DAMAGE = 300;

    public Assassin(String name) {
        super(name, ASSASSIN_BASE_STRENGTH, ASSASSIN_BASE_AGILITY,
                ASSASSIN_BASE_INTELLIGENCE, ASSASSIN_BASE_HITPOINTS, ASSASSIN_BASE_DAMAGE);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s, Class: %s%nHitPoints: %d, Damage: %d%n" +
                        "Strength: %d%nAgility: %d%nIntelligence: %d%n", super.getName()
                ,this.getClass().getSimpleName(), super.getHitPoints(), super.getDamage(), super.getStrength(),
                super.getAgility(), super.getIntelligence()));

        if (super.getItems().isEmpty()){
            sb.append("Items: None");
        } else {
            sb.append("Items: ").append(System.lineSeparator());
            super.getItems().forEach(sb::append);
        }

        return sb.toString().trim();
    }
}
