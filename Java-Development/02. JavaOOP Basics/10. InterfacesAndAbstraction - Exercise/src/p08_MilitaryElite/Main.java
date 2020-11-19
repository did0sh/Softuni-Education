package p08_MilitaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        Map<String, Private> privates = new LinkedHashMap<>();
        ArrayList<Private> allPrivatesToPrint = new ArrayList<>();

        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] info = input.split("\\s+");
            String classType = info[0];
            switch (classType){
                case "Private":
                    execPrivate(info, privates, allPrivatesToPrint);
                    break;
                case "LeutenantGeneral":
                    execGeneral(info, privates, allPrivatesToPrint);
                    break;
                case "Engineer":
                    if (info[5].equals("Airforces") || info[5].equals("Marines")){
                        execEngineer(info, allPrivatesToPrint);
                    }
                    break;
                case "Commando":
                    if (info[5].equals("Airforces") || info[5].equals("Marines")){
                        execCommando(info, allPrivatesToPrint);
                    }
                    break;
                case "Spy":
                    execSpy(info, allPrivatesToPrint);
                    break;
            }
        }

        printAllSoldiers(allPrivatesToPrint);
    }

    private static void printAllSoldiers(List<Private> allPrivates) {
        for (Private aPrivate : allPrivates) {
            System.out.print(aPrivate);
        }
    }

    private static void execSpy(String[] info , List<Private> allPrivates) {
        String id = info[1];
        String firstName = info[2];
        String lastName = info[3];
        String codeNumber = info[4];

        Spy spy = new Spy(id, firstName, lastName, 0, codeNumber);
        allPrivates.add(spy);
    }

    private static void execCommando(String[] info, List<Private> allPrivates) {
        String id = info[1];
        String firstName = info[2];
        String lastName = info[3];
        double salary = Double.parseDouble(info[4]);
        String corps = info[5];

        Commando commando = new Commando(id, firstName, lastName, salary, corps);
        for (int i = 6; i < info.length ; i+=2) {
            String missionCodeName = info[i];
            String missionState = info[i+1];

            if (!missionState.equals("inProgress") && !missionState.equals("Finished")){
                continue;
            }
            Mission mission = new Mission(missionCodeName, missionState);
            commando.addMission(mission);
        }

        allPrivates.add(commando);

    }

    private static void execEngineer(String[] info, List<Private> allPrivates) {
        String id = info[1];
        String firstName = info[2];
        String lastName = info[3];
        double salary = Double.parseDouble(info[4]);
        String corps = info[5];

        Engineer engineer = new Engineer(id, firstName, lastName, salary, corps);
        for (int i = 6; i < info.length ; i+=2) {
            String repairPartName = info[i];
            int repairHours = Integer.parseInt(info[i+1]);

            Repair repair = new Repair(repairPartName, repairHours);
            engineer.addRepair(repair);
        }

        allPrivates.add(engineer);

    }

    private static void execGeneral(String[] info, Map<String, Private> privates, List<Private> allPrivates) {
        String id = info[1];
        String firstName = info[2];
        String lastName = info[3];
        double salary = Double.parseDouble(info[4]);

        LeutenantGeneral general = new LeutenantGeneral(id, firstName, lastName, salary);
        for (int i = 5; i < info.length ; i++) {
            String privateId = info[i];
            Private currentSoldier = privates.get(privateId);
            general.addPrivate(currentSoldier);
        }

        allPrivates.add(general);
    }

    private static void execPrivate(String[] info, Map<String, Private> privates, List<Private> allPrivates) {
        String id = info[1];
        String firstName = info[2];
        String lastName = info[3];
        double salary = Double.parseDouble(info[4]);
        Private privateSoldier = new Private(id, firstName,lastName, salary);
        privates.put(id, privateSoldier);

        allPrivates.add(privateSoldier);
    }
}
