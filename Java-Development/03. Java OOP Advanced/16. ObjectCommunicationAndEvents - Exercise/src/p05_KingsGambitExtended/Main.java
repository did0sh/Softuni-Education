package p05_KingsGambitExtended;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Repository repo = new Repository();
        Identifiable king = new King(input);
        repo.addIdentifiable(king);

        String[] guardNames = reader.readLine().split(" ");
        for (String name : guardNames) {
            Identifiable royalGuard = new RoyalGuard(name);
            repo.addIdentifiable(royalGuard);
        }

        String[] footmanNames = reader.readLine().split(" ");
        for (String footmanName : footmanNames) {
            Identifiable footman = new Footman(footmanName);
            repo.addIdentifiable(footman);
        }

        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] commands = input.split(" ");
            switch (commands[0]){
                case "Kill":
                    String name = commands[1];
                    repo.kill(name);
                    break;
                case "Attack":
                    repo.attackKing();
                    break;
            }
        }
    }
}
