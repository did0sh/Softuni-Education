package blobs.factories;

import blobs.interfaces.Behavior;

public class BehaviorFactory {
    private static final String BEHAVIOR_PACKAGE = "blobs.models.behavors.";

    public Behavior createBehavior(String behaviorType) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<Behavior> behaviorClass = (Class<Behavior>) Class.forName(BEHAVIOR_PACKAGE + behaviorType);
        return behaviorClass.newInstance();
    }
}
