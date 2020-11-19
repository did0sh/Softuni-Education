import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class p02_WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\input.txt";
        String outputFile = "C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\Files-and-Streams\\output.txt";
        ArrayList<Character> symbols = new ArrayList<>();

        Collections.addAll(symbols, '.', ',', '!', '?');

        FileOutputStream fos = new FileOutputStream(outputFile);
        try (FileInputStream fis = new FileInputStream(path)){
            int oneByte = fis.read();
            while (oneByte >= 0){
                if (!symbols.contains((char)oneByte)){
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
