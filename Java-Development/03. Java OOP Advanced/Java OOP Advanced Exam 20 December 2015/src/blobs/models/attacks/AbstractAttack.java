package blobs.models.attacks;

import blobs.interfaces.Attack;
import blobs.models.Blob;

public abstract class AbstractAttack implements Attack {
    protected void targetRespond(Blob target, int damage) {
        int currentHealth = target.getHealth();
        currentHealth -= damage;
        target.setHealth(currentHealth);
    }
}
