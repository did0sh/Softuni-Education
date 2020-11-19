package hell.entities.heroes;

public class Wizard extends BaseHero {

    private static final Integer WIZARD_BASE_STRENGTH = 25;
    private static final Integer WIZARD_BASE_AGILITY = 25;
    private static final Integer WIZARD_BASE_INTELLIGENCE = 100;
    private static final Integer WIZARD_BASE_HITPOINTS = 100;
    private static final Integer WIZARD_BASE_DAMAGE = 250;


    public Wizard(String name) {
        super(name, WIZARD_BASE_STRENGTH, WIZARD_BASE_AGILITY,
                WIZARD_BASE_INTELLIGENCE, WIZARD_BASE_HITPOINTS, WIZARD_BASE_DAMAGE);
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
