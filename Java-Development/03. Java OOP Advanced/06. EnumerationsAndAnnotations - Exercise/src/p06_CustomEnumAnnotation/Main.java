package p06_CustomEnumAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String classType = reader.readLine();
        Class<?> cardClass = null;
        switch (classType){
            case "Rank":
                cardClass = RankType.class;
                break;
            case "Suit":
                cardClass = SuitType.class;
                break;
        }

        CustomAnnotation annotation = cardClass.getAnnotation(CustomAnnotation.class);
        System.out.println(String.format("Type = %s, Description = %s",
                annotation.type(), annotation.description()));
    }
}
