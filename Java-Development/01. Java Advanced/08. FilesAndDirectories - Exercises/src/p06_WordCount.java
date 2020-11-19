import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class p06_WordCount {
    public static void main(String[] args) {
        ArrayList<String> wordsToSearch = new ArrayList<>();
        Path file = Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Path textFile = Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");

        try(BufferedReader reader = Files.newBufferedReader(file)) {
            PrintWriter writer = new PrintWriter("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt");
            String[] words = reader.readLine().split("\\s+");
            wordsToSearch.addAll(Arrays.asList(words));

            BufferedReader bf = Files.newBufferedReader(textFile);
            String[] textWords = bf.readLine().split("\\s+");
            for (int i = 0; i < wordsToSearch.size(); i++) {
                int currentWordCount = 0;
                String currentWord = wordsToSearch.get(i);
                for (int j = 0; j < textWords.length; j++) {
                    if (textWords[j].equals(currentWord)){
                        currentWordCount++;
                    }
                }
                writer.printf("%s - %d%n", currentWord, currentWordCount);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
