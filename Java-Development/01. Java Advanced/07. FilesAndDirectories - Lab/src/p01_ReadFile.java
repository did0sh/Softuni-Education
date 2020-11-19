import java.io.FileInputStream;
import java.io.IOException;

public class p01_ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\input.txt";

        try (FileInputStream fis = new FileInputStream(path)){
            int oneByte = fis.read();
            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fis.read();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
