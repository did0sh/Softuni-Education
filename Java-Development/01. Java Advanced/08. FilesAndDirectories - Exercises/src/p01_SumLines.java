import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class p01_SumLines {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"))) {
            String line  = reader.readLine();
            while (line != null){
                long sum = 0;
                char[] characters = line.toCharArray();
                for (char character : characters) {
                    sum += character;
                }
                System.out.println(sum);
                line = reader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
