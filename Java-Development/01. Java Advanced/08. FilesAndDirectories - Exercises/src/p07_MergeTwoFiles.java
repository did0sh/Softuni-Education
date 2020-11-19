import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class p07_MergeTwoFiles {
    public static void main(String[] args) {
        Path input1 = Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path input2 = Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");

        try (BufferedReader reader = Files.newBufferedReader(input1);
             BufferedReader secondReader = Files.newBufferedReader(input2)) {
            PrintWriter writer = new PrintWriter("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\merging.txt");
            String line = reader.readLine();
            while (line != null) {
                writer.println(line);
                line = reader.readLine();
            }
            String lineSecondInput = secondReader.readLine();
            while (lineSecondInput != null) {
                writer.println(lineSecondInput);
                lineSecondInput = secondReader.readLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
