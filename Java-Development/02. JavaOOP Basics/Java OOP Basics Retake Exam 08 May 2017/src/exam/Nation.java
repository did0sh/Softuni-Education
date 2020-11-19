package exam;

import exam.monuments.AirMonument;
import exam.monuments.EarthMonument;
import exam.monuments.FireMonument;
import exam.monuments.WaterMonument;

import java.util.*;
import java.util.stream.Collectors;

public class Nation {
    private Map<Monument, Integer> monuments;
    private Map<Bender, Integer> nationsAndIncreasedPower;
    private Map<List<Bender>, Integer> finalMap;
    private int count;
    private StringBuilder sb = new StringBuilder();

    public Nation() {
        this.finalMap = new LinkedHashMap<>();
        this.monuments = new LinkedHashMap<>();
        this.nationsAndIncreasedPower = new LinkedHashMap<>();
    }

    public void addBenderToNation(Bender bender) {
        this.nationsAndIncreasedPower.put(bender, bender.getPower());
    }

    public void addMonument(Monument monument) {
        this.monuments.put(monument, monument.getProperty());
    }

    public Map<Bender, Integer> getNationsAndIncreasedPower() {
        return this.nationsAndIncreasedPower;
    }

    public Map<List<Bender>, Integer> getFinalMap() {
        return this.finalMap;
    }

    public Map<Monument, Integer> getMonuments() {
        return this.monuments;
    }

    public String increaseTotalPower(String type) {
        this.sb.setLength(0);
        int totalPowerNation = 0;
        int increasedByMonuments = 0;

        switch (type) {
            case "Air":
                increasedByMonuments = this.monuments.entrySet().stream()
                        .filter(monument -> monument.getKey().getClass().getSimpleName().equals("AirMonument"))
                        .mapToInt(Map.Entry::getValue).sum();


                List<Bender> airBenders = this.nationsAndIncreasedPower
                        .keySet().stream()
                        .filter(nation -> nation.getClass().getSimpleName().equals("AirBender"))
                        .collect(Collectors.toList());

                if (airBenders.size() != 0){
                    totalPowerNation = airBenders.stream().mapToInt(Bender::getPower).sum();


                    int increased = totalPowerNation + totalPowerNation * (increasedByMonuments / 100);
                    this.finalMap.put(airBenders, increased);
                }
                break;
            case "Earth":
                increasedByMonuments = this.monuments.entrySet().stream()
                        .filter(monument -> monument.getKey().getClass().getSimpleName().equals("EarthMonument"))
                        .mapToInt(Map.Entry::getValue).sum();

                List<Bender> earthBenders = this.nationsAndIncreasedPower
                        .keySet().stream()
                        .filter(nation -> nation.getClass().getSimpleName().equals("EarthBender"))
                        .collect(Collectors.toList());

                if (earthBenders.size() != 0){
                    totalPowerNation = earthBenders.stream().mapToInt(Bender::getPower).sum();


                    int increasedEarth = totalPowerNation + totalPowerNation * (increasedByMonuments / 100);
                    this.finalMap.put(earthBenders, increasedEarth);
                }
                break;
            case "Fire":
                increasedByMonuments = this.monuments.entrySet().stream()
                        .filter(monument -> monument.getKey().getClass().getSimpleName().equals("FireMonument"))
                        .mapToInt(Map.Entry::getValue).sum();


                List<Bender> fireBenders = this.nationsAndIncreasedPower
                        .keySet().stream()
                        .filter(nation -> nation.getClass().getSimpleName().equals("FireBender"))
                        .collect(Collectors.toList());

                if (fireBenders.size() != 0){
                    totalPowerNation = fireBenders.stream().mapToInt(Bender::getPower).sum();


                    int increasedFire = totalPowerNation + totalPowerNation * (increasedByMonuments / 100);
                    this.finalMap.put(fireBenders, increasedFire);
                }
                break;
            case "Water":
                increasedByMonuments = this.monuments.entrySet().stream()
                        .filter(monument -> monument.getKey().getClass().getSimpleName().equals("WaterMonument"))
                        .mapToInt(Map.Entry::getValue).sum();


                List<Bender> waterBender = this.nationsAndIncreasedPower
                        .keySet().stream()
                        .filter(nation -> nation.getClass().getSimpleName().equals("WaterBender"))
                        .collect(Collectors.toList());

                if (waterBender.size() != 0){
                    totalPowerNation = waterBender.stream().mapToInt(Bender::getPower).sum();

                    int increasedWater = totalPowerNation + totalPowerNation * (increasedByMonuments / 100);
                    this.finalMap.put(waterBender, increasedWater);

                }
                break;
        }
        this.sb.append(String.format("War %d issued by %s%n", ++this.count, type));
        return sb.toString();
    }

    public String printDifferentTypes(String type) {
        this.sb.setLength(0);
        this.sb.append(String.format("%s Nation%n", type));

        switch (type) {
            case "Air":
                List<Bender> airBenders = this.getNationsAndIncreasedPower().keySet().stream()
                        .filter(nation -> nation.getClass().getSimpleName().equals("AirBender"))
                        .collect(Collectors.toList());


                if (airBenders.size() == 0) {
                    sb.append("Benders: None").append(System.lineSeparator());
                } else {
                    sb.append("Benders:").append(System.lineSeparator());
                    airBenders.forEach(bender -> sb.append("###").append(bender));
                }

                List<Monument> airMonuments = this.monuments.keySet().stream()
                        .filter(monument -> monument.getClass().getSimpleName().equals("AirMonument"))
                        .collect(Collectors.toList());

                if (airMonuments.size() == 0) {
                    sb.append("Monuments: None").append(System.lineSeparator());
                } else {
                    sb.append("Monuments:").append(System.lineSeparator());
                    airMonuments.forEach(monument -> sb.append("###").append(monument));
                }

                break;
            case "Water":
                List<Bender> waterBenders = this.getNationsAndIncreasedPower().keySet().stream()
                        .filter(nation -> nation.getClass().getSimpleName().equals("WaterBender"))
                        .collect(Collectors.toList());


                if (waterBenders.size() == 0) {
                    sb.append("Benders: None").append(System.lineSeparator());
                } else {
                    sb.append("Benders:").append(System.lineSeparator());
                    waterBenders.forEach(bender -> sb.append("###").append(bender));
                }

                List<Monument> waterMonuments = this.monuments.keySet().stream()
                        .filter(monument -> monument.getClass().getSimpleName().equals("WaterMonument"))
                        .collect(Collectors.toList());

                if (waterMonuments.size() == 0) {
                    sb.append("Monuments: None").append(System.lineSeparator());
                } else {
                    sb.append("Monuments:").append(System.lineSeparator());
                    waterMonuments.forEach(monument -> sb.append("###").append(monument));
                }
                break;
            case "Fire":
                List<Bender> fireBenders = this.getNationsAndIncreasedPower().keySet().stream()
                        .filter(nation -> nation.getClass().getSimpleName().equals("FireBender"))
                        .collect(Collectors.toList());


                if (fireBenders.size() == 0) {
                    sb.append("Benders: None").append(System.lineSeparator());
                } else {
                    sb.append("Benders:").append(System.lineSeparator());
                    fireBenders.forEach(bender -> sb.append("###").append(bender));
                }

                List<Monument> fireMonuments = this.monuments.keySet().stream()
                        .filter(monument -> monument.getClass().getSimpleName().equals("FireMonument"))
                        .collect(Collectors.toList());

                if (fireMonuments.size() == 0) {
                    sb.append("Monuments: None").append(System.lineSeparator());
                } else {
                    sb.append("Monuments:").append(System.lineSeparator());
                    fireMonuments.forEach(monument -> sb.append("###").append(monument));
                }
                break;
            case "Earth":
                List<Bender> earthBenders = this.getNationsAndIncreasedPower().keySet().stream()
                        .filter(nation -> nation.getClass().getSimpleName().equals("EarthBender"))
                        .collect(Collectors.toList());


                if (earthBenders.size() == 0) {
                    sb.append("Benders: None").append(System.lineSeparator());
                } else {
                    sb.append("Benders:").append(System.lineSeparator());
                    earthBenders.forEach(bender -> sb.append("###").append(bender));
                }

                List<Monument> earthMonuments = this.monuments.keySet().stream()
                        .filter(monument -> monument.getClass().getSimpleName().equals("EarthMonument"))
                        .collect(Collectors.toList());

                if (earthMonuments.size() == 0) {
                    sb.append("Monuments: None").append(System.lineSeparator());
                } else {
                    sb.append("Monuments:").append(System.lineSeparator());
                    earthMonuments.forEach(monument -> sb.append("###").append(monument));
                }
                break;
        }
        return sb.toString();
    }


}
