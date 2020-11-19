
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class p06_SortLines {
    public static void main(String[] args) throws IOException {
        Path inputFile = Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\ABCD.txt");
        Path outputFile = Paths.get("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\Files-and-Streams\\output5.txt");

       try{
           List<String> lines = Files.readAllLines(inputFile);
           Collections.sort(lines);
           Files.write(outputFile, lines);
       }catch (IOException e){
           e.printStackTrace();
       }

    }
}
