import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class p03_CopyBites {
    public static void main(String[] args) {
        String outputhFile = "C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\Files-and-Streams\\output2.txt";
        String inputhFile = "C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\Files-and-Streams\\input.txt";

        try (FileInputStream fis = new FileInputStream(inputhFile)) {
            FileOutputStream fos = new FileOutputStream(outputhFile);

            int oneByte = fis.read();
            int asciiCodeWhiteSpace = 32;
            int asciiCodeNewLine = 10;
            while (oneByte >= 0){
                if (oneByte == asciiCodeWhiteSpace || oneByte == asciiCodeNewLine){
                    fos.write(oneByte);
                } else {
                    char[] characters = String.valueOf(oneByte).toCharArray();
                    for (char character : characters) {
                        fos.write(character);
                    }
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
