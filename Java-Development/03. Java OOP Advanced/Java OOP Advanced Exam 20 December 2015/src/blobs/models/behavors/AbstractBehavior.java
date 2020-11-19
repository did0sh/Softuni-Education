package blobs.models.behavors;

import blobs.interfaces.Behavior;
import blobs.models.Blob;

public abstract class AbstractBehavior implements Behavior {

    protected boolean isTriggered;
    protected boolean toDelayRecurrentEffect;

    protected AbstractBehavior() {
        this.toDelayRecurrentEffect = true;
    }

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }

    public void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    public boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }

    @Override
    public abstract void trigger(Blob source);

    @Override
    public abstract void applyRecurrentEffect(Blob source);
}
