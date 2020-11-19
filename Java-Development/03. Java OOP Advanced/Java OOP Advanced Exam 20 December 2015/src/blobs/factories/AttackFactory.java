package blobs.factories;

import blobs.interfaces.Attack;

public class AttackFactory {
    private static final String ATTACK_PACKAGE = "blobs.models.attacks.";

    public Attack createAttack(String attackType) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Class<Attack> attackClass = (Class<Attack>) Class.forName(ATTACK_PACKAGE + attackType);
        return attackClass.newInstance();
    }
}
