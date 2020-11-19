package p02_KingsGambit;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {
    private Map<String,Identifiable> identifiables;

    public Repository() {
        this.identifiables = new LinkedHashMap<>();
    }

    public void addIdentifiable(Identifiable identifiable){
        this.identifiables.put(identifiable.getName(), identifiable);
    }

    public void attackKing(){
        this.identifiables.values().stream()
        .filter(identifiable -> identifiable.getClass().getSimpleName().equals("King")).limit(1)
                .forEach(identifiable -> System.out.printf("King %s is under attack!%n", identifiable.getName()));

        this.identifiables.values().stream()
                .filter(identifiable -> identifiable.getClass().getSimpleName().equals("RoyalGuard"))
                .forEach(identifiable -> System.out.printf("Royal Guard %s is defending!%n", identifiable.getName()));

        this.identifiables.values().stream()
                .filter(identifiable -> identifiable.getClass().getSimpleName().equals("Footman"))
                .forEach(identifiable -> System.out.printf("Footman %s is panicking!%n", identifiable.getName()));
    }

    public void kill(String name){
        if (this.identifiables.containsKey(name)){
            this.identifiables.remove(name);
        }
    }
}
