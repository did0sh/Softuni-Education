package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {
        private List<Targetable> participants;
    @Override
    public String executeAction(List<Targetable> participants) {
        this.participants = participants;

        if (this.participants.size() < 2){
            return "There should be at least 1 participant for boss fight!";
        }

        StringBuilder sb = new StringBuilder();

        Targetable boss = participants.get(0);
        List<Targetable> heroes = participants.stream().skip(1).collect(Collectors.toList());

        while (heroes.size() > 0){
            for (int i = 0; i < heroes.size() ; i++) {
                Targetable currentAttacker = heroes.get(i);
                currentAttacker.attack(boss);
                if (!boss.isAlive()){
                    boss.giveReward(currentAttacker);
                    heroes.forEach(hero -> hero.receiveReward(Config.BOSS_INDIVIDUAL_REWARD));
                    heroes.stream().filter(hero -> !hero.equals(currentAttacker))
                                .forEach(Targetable::levelUp);

                    sb.append("Boss has been slain by:").append(System.lineSeparator());

                    heroes.stream().sorted(Comparator.comparing(Targetable::getName))
                     .forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));

                    return sb.toString().trim();
                }
                boss.attack(currentAttacker);
                if (!currentAttacker.isAlive()){
                    heroes.remove(i--);
                }
            }
        }

        sb.append("Boss has slain them all!").append(System.lineSeparator());
        return sb.toString().trim();
    }
}
