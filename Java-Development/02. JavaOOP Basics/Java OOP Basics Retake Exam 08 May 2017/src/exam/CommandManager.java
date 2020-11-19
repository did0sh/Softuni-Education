package exam;

import exam.benders.AirBender;
import exam.benders.EarthBender;
import exam.benders.FireBender;
import exam.benders.WaterBender;
import exam.monuments.AirMonument;
import exam.monuments.EarthMonument;
import exam.monuments.FireMonument;
import exam.monuments.WaterMonument;

import java.util.*;
import java.util.stream.Collectors;

public class CommandManager {

    private Nation nation;
    public CommandManager() {
        this.nation = new Nation();
    }

    public void createBender(String type, String name, int power, double additionalProperty){
        Bender bender = null;
        switch (type){
            case "Air":
                bender = new AirBender(name, power, additionalProperty);
                this.nation.addBenderToNation(bender);
                break;
            case "Water":
                bender = new WaterBender(name, power, additionalProperty);
                this.nation.addBenderToNation(bender);
                break;
            case "Fire":
                bender = new FireBender(name, power, additionalProperty);
                this.nation.addBenderToNation(bender);
                break;
            case "Earth":
                bender = new EarthBender(name, power, additionalProperty);
                this.nation.addBenderToNation(bender);
                break;
        }
    }

    public void createMonument(String type, String name, int affinity){
        Monument monument = null;
        switch (type){
            case "Air":
                monument = new AirMonument(name, affinity);
                this.nation.addMonument(monument);
                break;
            case "Water":
                monument = new WaterMonument(name, affinity);
                this.nation.addMonument(monument);
                break;
            case "Fire":
                monument = new FireMonument(name, affinity);
                this.nation.addMonument(monument);
                break;
            case "Earth":
                monument = new EarthMonument(name, affinity);
                this.nation.addMonument(monument);
                break;
        }
    }

    public String status(String nationType){
        return this.nation.printDifferentTypes(nationType);
    }

    public String war(String nation){
        return this.nation.increaseTotalPower(nation);
    }

    public void removeBendersAndMonuments(){
       List<Map.Entry<List<Bender>, Integer>> winner = this.nation.getFinalMap().entrySet()
                .stream().sorted((k1,k2) -> k2.getValue() - k1.getValue())
                .limit(1).collect(Collectors.toList());

       List<Monument> monumentsList = new ArrayList<>();
       String type = winner.get(0).getKey().get(0).getClass().getSimpleName();

       if (type.equals("FireBender")){
           monumentsList = this.nation.getMonuments().keySet()
                   .stream().filter(monument -> monument.getClass().getSimpleName().equals("FireMonument"))
                   .collect(Collectors.toList());

           this.nation.getMonuments().clear();
       } else if (type.equals("WaterBender")){
           monumentsList = this.nation.getMonuments().keySet()
                   .stream().filter(monument -> monument.getClass().getSimpleName().equals("WaterMonument"))
                   .collect(Collectors.toList());

           this.nation.getMonuments().clear();
       } else if (type.equals("EarthBender")){
           monumentsList = this.nation.getMonuments().keySet()
                   .stream().filter(monument -> monument.getClass().getSimpleName().equals("EarthMonument"))
                   .collect(Collectors.toList());

           this.nation.getMonuments().clear();
       } else if (type.equals("AirBender")){
           monumentsList = this.nation.getMonuments().keySet()
                   .stream().filter(monument -> monument.getClass().getSimpleName().equals("AirMonument"))
                   .collect(Collectors.toList());

           this.nation.getMonuments().clear();
       }

        for (Monument monument : monumentsList) {
            this.nation.getMonuments().put(monument, monument.getProperty());
        }

        this.nation.getNationsAndIncreasedPower().clear();

        for (int i = 0; i < winner.get(0).getKey().size(); i++) {
            this.nation.getNationsAndIncreasedPower().put(winner.get(0).getKey().get(i), winner.get(0).getValue());
        }

    }
}
