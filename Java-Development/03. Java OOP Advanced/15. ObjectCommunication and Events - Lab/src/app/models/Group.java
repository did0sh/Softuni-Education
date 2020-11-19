package app.models;

import app.interfaces.AttackGroup;
import app.interfaces.Attacker;
import app.interfaces.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {
    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {
        this.attackers.forEach(attacker -> attacker.setTarget(target));
    }

    @Override
    public void groupAttack() {
        this.attackers.forEach(Attacker::attack);
    }
}
