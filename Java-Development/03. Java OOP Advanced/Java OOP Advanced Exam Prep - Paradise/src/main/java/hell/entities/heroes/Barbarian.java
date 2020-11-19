package hell.entities.heroes;

public class Barbarian extends BaseHero {

    private static final Integer BARBARIAN_BASE_STRENGTH = 90;
    private static final Integer BARBARIAN_BASE_AGILITY = 25;
    private static final Integer BARBARIAN_BASE_INTELLIGENCE = 10;
    private static final Integer BARBARIAN_BASE_HITPOINTS = 350;
    private static final Integer BARBARIAN_BASE_DAMAGE = 150;

    public Barbarian(String name) {
        super(name, BARBARIAN_BASE_STRENGTH, BARBARIAN_BASE_AGILITY, BARBARIAN_BASE_INTELLIGENCE,
                BARBARIAN_BASE_HITPOINTS, BARBARIAN_BASE_DAMAGE);
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
