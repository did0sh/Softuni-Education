package p10p11p12p13p14_InfernoInfinity;

@CustomClassAnnotation(author = "Pesho", revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.", reviewers = {"Pesho, Svetlio"})
public class Weapon implements Comparable<Weapon> {
    private String name;
    private WeaponType weaponType;
    private GemType[] gemTypes;

    private int minDamage;
    private int maxDamage;
    private int strength;
    private int agility;
    private int vitality;

    private double itemLevel;

    public Weapon(String name, WeaponType weaponType) {
        this.name = name;
        this.weaponType = weaponType;
        this.gemTypes = new GemType[weaponType.getSockets()];

        this.getWeaponStats();
    }

    private void getWeaponStats(){
        this.minDamage += this.weaponType.getMinDamage();
        this.maxDamage += this.weaponType.getMaxDamage();
    }

    private void increaseStrength(int strength){
        this.strength += strength;
        this.minDamage += 2 * strength;
        this.maxDamage += 3 * strength;
    }

    private void increaseAgility(int agility){
        this.agility += agility;
        this.minDamage += agility;
        this.maxDamage += 4 * agility;
    }

    private void increaseVitality(int vitality){
        this.vitality += vitality;
    }

    public void increaseWeaponAllStats(GemType gemType){
        this.increaseStrength(gemType.getStrength());
        this.increaseAgility(gemType.getAgility());
        this.increaseVitality(gemType.getVitality());
    }

    private void decreaseStrength(int strength){
        this.strength -= strength;
        this.minDamage -= 2 * strength;
        this.maxDamage -= 3 * strength;
    }

    private void decreaseAgility(int agility){
        this.agility -= agility;
        this.minDamage -= agility;
        this.maxDamage -= 4 * agility;
    }

    private void decreaseVitality(int vitality){
        this.vitality -= vitality;
    }

    public void decreaseWeaponAllStats(GemType gemType){
        this.decreaseStrength(gemType.getStrength());
        this.decreaseAgility(gemType.getAgility());
        this.decreaseVitality(gemType.getVitality());
    }

    private double getItemLevel(){
        this.itemLevel = ((this.getMinDamage() + this.getMaxDamage()) / 2.0) + this.getStrength()
                    + this.getAgility() + this.getVitality();
        return this.itemLevel;
    }

    public GemType[] getGemTypes() {
        return this.gemTypes;
    }

    private String getName() {
        return this.name;
    }

    private int getMinDamage() {
        return this.minDamage;
    }

    private int getMaxDamage() {
        return this.maxDamage;
    }

    private int getStrength() {
        return this.strength;
    }

    private int getAgility() {
        return this.agility;
    }

    private int getVitality() {
        return this.vitality;
    }

    public void printWithItemLevel(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f)",
                this.getName(), this.getMinDamage(), this.getMaxDamage(),
                this.getStrength(), this.getAgility(), this.getVitality(), this.getItemLevel()));
        System.out.println(sb.toString());
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.getItemLevel(), o.getItemLevel());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(), this.getMinDamage(), this.getMaxDamage(),
                this.getStrength(), this.getAgility(), this.getVitality()));
        return sb.toString();
    }
}
