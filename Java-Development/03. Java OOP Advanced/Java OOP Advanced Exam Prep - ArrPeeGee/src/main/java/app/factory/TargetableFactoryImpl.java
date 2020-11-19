package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.models.participants.Boss;
import app.models.participants.Necromancer;
import app.models.participants.Warrior;
import app.models.participants.Wizard;

public class TargetableFactoryImpl implements TargetableFactory {
    @Override
    public Targetable create(String name, String className){
        switch (className){
            case "Warrior":
                return new Warrior(name);
            case "Wizard":
                return new Wizard(name);
            case "Necromancer":
                return new Necromancer(name);
            case "Boss":
                return new Boss(name);
        }
        return null;
    }
}
