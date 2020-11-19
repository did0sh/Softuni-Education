package p10p11p12p13p14_InfernoInfinity;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, Weapon> weapons;

    public CommandManager() {
        this.weapons = new LinkedHashMap<>();
    }

    public void create(String weaponType, String weaponName) {
        Weapon weapon = new Weapon(weaponName, WeaponType.valueOf(weaponType));
        this.weapons.put(weaponName, weapon);
    }

    public void add(String weaponName, int socketIndex, String gemType) {
        Weapon weapon = this.weapons.get(weaponName);
        GemType gem = GemType.valueOf(gemType);

        if (socketIndex >= 0 && socketIndex <= weapon.getGemTypes().length - 1) {
            if (weapon.getGemTypes()[socketIndex] != null) {  // if already a gem, decreaseStats
                this.removeGem(weaponName, socketIndex);
            }

            weapon.increaseWeaponAllStats(gem); // increaseStats
            weapon.getGemTypes()[socketIndex] = gem; // put gem on position
        }
    }

    public void removeGem(String weaponName, int socketIndex) {
        Weapon weapon = this.weapons.get(weaponName);
        if (weapon.getGemTypes().length != 0 && weapon.getGemTypes()[socketIndex] != null) {
            GemType gemType = weapon.getGemTypes()[socketIndex];
            weapon.getGemTypes()[socketIndex] = null;
            weapon.decreaseWeaponAllStats(gemType);
        }
    }

    public void print(String weaponName) {
        Weapon weapon = this.weapons.get(weaponName);
        System.out.println(weapon);
    }

    public void compare(String weaponName, String otherWeaponName){
        Weapon weapon = this.weapons.get(weaponName);
        Weapon other = this.weapons.get(otherWeaponName);

        if (weapon.compareTo(other) >= 0){
            weapon.printWithItemLevel();
        } else {
            other.printWithItemLevel();
        }
    }
}
