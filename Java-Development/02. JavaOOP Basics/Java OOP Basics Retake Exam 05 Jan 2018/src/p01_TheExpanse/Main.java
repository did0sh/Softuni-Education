package p01_TheExpanse;

import p01_TheExpanse.colonists.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        int maxFamilyCount = Integer.parseInt(tokens[0]);
        int maxFamilyCapacity = Integer.parseInt(tokens[1]);
        Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);

        for (String line = reader.readLine(); !line.equals("end"); line = reader.readLine()) {
            tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "insert":
                    try {
                        insertColonist(colony, tokens);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "remove":
                    remove(colony, tokens);
                    break;
                case "grow":
                    int years = Integer.parseInt(tokens[1]);
                    colony.grow(years);
                    break;
                case "potential":
                    System.out.println("potential: " + colony.getPotential());
                    break;
                case "capacity":
                    System.out.println(colony.getCapacity());
                    break;
                case "family":
                    String familyId = tokens[1];
                    Family family = colony.getFamilyById(familyId);
                    if (family != null) {
                        System.out.println(family);
                    } else {
                        System.out.println("family does not exist");
                    }
                    break;

            }
        }
    }

    private static void remove(Colony colony, String[] tokens) {
        String modificator = tokens[1];
        String familyId = tokens[2];
        switch (modificator) {
            case "family":
                colony.removeFamily(familyId);
                return;
            case "colonist":
                String colonistId = tokens[3];
                colony.removeColonist(familyId, colonistId);
        }
    }

    private static void insertColonist(Colony colony, String[] tokens) {
        String colonistClass = tokens[1];
        String colonistId = tokens[2];
        String familyId = tokens[3];
        int talent = Integer.parseInt(tokens[4]);
        int age = Integer.parseInt(tokens[5]);
        Colonist colonist;
        switch (colonistClass) {
            case "Soldier":
                colonist = new Soldier(colonistId, familyId, talent, age);
                colony.addColonist(colonist);
                return;
            case "SoftwareEngineer":
                colonist = new SoftwareEngineer(colonistId, familyId, talent, age);
                colony.addColonist(colonist);
                return;
            case "HardwareEngineer":
                colonist = new HardwareEngineer(colonistId, familyId, talent, age);
                colony.addColonist(colonist);
                return;
            case "Surgeon":
                String sign = tokens[6];
                colonist = new Surgeon(colonistId, familyId, talent, age, sign);
                colony.addColonist(colonist);
                return;
            case "GeneralPractitioner":
                String sign2 = tokens[6];
                colonist = new GeneralPractitioner(colonistId, familyId, talent, age, sign2);
                colony.addColonist(colonist);
        }
    }
}
