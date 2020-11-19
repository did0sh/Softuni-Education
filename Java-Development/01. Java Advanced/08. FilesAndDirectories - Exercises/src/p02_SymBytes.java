import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class p02_SymBytes {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = reader.readLine();
            long sum = 0;
            while (line != null){
                char[] characters = line.toCharArray();
                for (char character : characters) {
                    sum += character;
                }
                line = reader.readLine();
            }
            System.out.println(sum);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
