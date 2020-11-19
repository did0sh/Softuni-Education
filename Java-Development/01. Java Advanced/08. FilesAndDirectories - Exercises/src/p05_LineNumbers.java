import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class p05_LineNumbers {
    public static void main(String[] args) {
        long counter = 1;
        Path file = Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        try(BufferedReader reader = Files.newBufferedReader(file)) {
            String line = reader.readLine();
            PrintWriter writer = new PrintWriter("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
            while (line != null){
                writer.printf("%d. %s%n", counter++, line);
                line = reader.readLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
