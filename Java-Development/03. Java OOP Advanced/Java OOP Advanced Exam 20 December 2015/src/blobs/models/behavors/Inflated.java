package blobs.models.behavors;

import blobs.models.Blob;

public class Inflated extends AbstractBehavior {
    private static final int INFLATED_HEALTH_ADDER = 50;
    private static final int INFLATED_HEALTH_SUBSTRACTER = 10;

    private int sourceInitalHealth;

    public Inflated() {
        super();
    }

    @Override
    public void trigger(Blob source) {
        this.sourceInitalHealth = source.getHealth();
        super.setIsTriggered(true);
        this.applyTriggerEffect(source);
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setHealth(source.getHealth() - INFLATED_HEALTH_SUBSTRACTER);
        }
    }

    private void applyTriggerEffect(Blob source) {
        source.setHealth(source.getHealth() + INFLATED_HEALTH_ADDER);
    }
}
