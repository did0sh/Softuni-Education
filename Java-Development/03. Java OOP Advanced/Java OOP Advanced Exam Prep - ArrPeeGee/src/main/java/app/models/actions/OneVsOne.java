package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;

public class OneVsOne implements Action {

    List<Targetable> participants;

    public String executeAction(List<Targetable> participants) {

        this.participants = participants;

        if (this.participants.size() != 2){
            return "There should be exactly 2 participants for OneVsOne!";
        }

        StringBuilder sb = new StringBuilder();

        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        while (firstHero.isAlive() && secondHero.isAlive()){
            sb.append(firstHero.attack(secondHero)).append(System.lineSeparator());
            if (firstHero.isAlive() && secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero)).append(System.lineSeparator());
            }
        }

        if (firstHero.isAlive()){
            sb.append(String.format("%s is victorious!%s%s", firstHero.getName(), System.lineSeparator(),firstHero.toString()));
        }else {
            sb.append(String.format("%s is victorious!%s%s", firstHero.getName(), System.lineSeparator(),firstHero.toString()));
        }

        return sb.toString();
    }
}
