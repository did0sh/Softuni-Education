package app.contracts;

import java.lang.reflect.InvocationTargetException;

public interface Battlefield {

    void createAction(String actionName, String... participantNames);

    void createParticipant(String heroName, String heroClassName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    void createSpecial(String heroName, String specialName);

    void reportParticipants();

    void reportActions();
}
