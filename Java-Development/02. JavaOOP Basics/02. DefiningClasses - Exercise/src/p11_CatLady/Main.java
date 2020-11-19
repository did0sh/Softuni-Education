package p11_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<String, Cat> cats = new LinkedHashMap<>();

        while (!"end".equalsIgnoreCase(input)){
            Cat cat = null;
            String[] info = input.split("\\s+");
            String type = info[0];
            String name = info[1];


            switch (type){
                case "Cymric":
                    double furLength = Double.parseDouble(info[2]);
                    cat = new Cymric(name, furLength);
                    break;
                case "StreetExtraordinaire":
                    double decibleMeow = Double.parseDouble(info[2]);
                    cat = new StreetExtraordinaire(name, decibleMeow);
                    break;
                case "Siamese":
                    double earSize = Double.parseDouble(info[2]);
                    cat = new Siamese(name, earSize);
                    break;
            }
            cats.put(name, cat);
            input = reader.readLine();
        }

        input = reader.readLine();
        System.out.print(cats.get(input));
    }
}
