import java.io.File;

public class p07_ListFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\Files-and-Streams");

        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                assert files != null;
                for (File f : files) {
                    if (!f.isDirectory()){
                        System.out.println(f.length());
                    }
                }
            }
        }
    }
}
