import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class p03_AllCapitals {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        try (BufferedReader reader = Files.newBufferedReader(file)){
            PrintWriter writer = new PrintWriter("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
            String line = reader.readLine();
            while (line != null){
                String text = line.toUpperCase();
                System.out.println(text);
                writer.println(text);
                line = reader.readLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
