import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class p04_CountCharacterTypes {
    public static void main(String[] args) {
        Path file = Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> punctuation = new ArrayList<>();

        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        Collections.addAll(punctuation, '.', ',', '!', '?');
        long vowelsCount = 0;
        long consonantsCount = 0;
        long punctuationCount = 0;

        try(BufferedReader reader = Files.newBufferedReader(file)) {
            PrintWriter writer = new PrintWriter("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
            String line = reader.readLine();
            while (line != null){
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    char[] word = words[i].toCharArray();
                    for (char c : word) {
                        if (vowels.contains(c)){
                            vowelsCount++;
                        } else if (punctuation.contains(c)){
                            punctuationCount++;
                        } else {
                            consonantsCount++;
                        }
                    }
                }
                line = reader.readLine();
            }
            writer.printf("Vowels: %d%n",vowelsCount);
            writer.printf("Consonants: %d%n",consonantsCount);
            writer.printf("Punctuation: %d%n",punctuationCount);

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
