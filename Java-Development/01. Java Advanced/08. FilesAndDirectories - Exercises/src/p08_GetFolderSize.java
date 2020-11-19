import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class p08_GetFolderSize {
    public static void main(String[] args) {
        Deque<File> files = new ArrayDeque<>();
        File projectFolder = new File("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        files.add(projectFolder);
        int folderSize = 0;

        while (!files.isEmpty()){
            File currFile = files.remove();

            if (currFile.isDirectory()){
                File[] currentFiles = currFile.listFiles();
                for (File file : currentFiles) {
                    if (file.isDirectory()){
                        files.add(file);
                    } else {
                        folderSize += file.length();
                    }
                }
            } else {
                folderSize += currFile.length();
            }
        }

        try(PrintWriter writer = new PrintWriter("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\08. FilesAndDirectories - Exercises\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\foldersize.txt")) {
            writer.printf("Folder size: %d", folderSize);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
