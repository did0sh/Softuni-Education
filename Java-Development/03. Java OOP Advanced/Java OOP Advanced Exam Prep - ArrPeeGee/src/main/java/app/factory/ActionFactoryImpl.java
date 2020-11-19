package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;
import app.models.actions.BossFight;
import app.models.actions.OneVsOne;

public class ActionFactoryImpl implements ActionFactory {
    private static final String ACTION_PACKAGE = "app.models.actions.";

    @Override
    public Action create(String actionName, String... participantNames) {
        switch (actionName){
            case "OneVsOne":
                return new OneVsOne();
            case "BossFight":
                return new BossFight();
        }
        return null;
    }
}
