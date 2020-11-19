import java.io.File;
import java.util.ArrayDeque;

public class p08_NestedFolders {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src");

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(file);

        int counter = 1;
        while (!queue.isEmpty()){
            File currentDirectory = queue.remove();
            File[] files = currentDirectory.listFiles();

            if (files == null){
                continue;
            }

            for (File f : files) {
                if (f.isDirectory()){
                    counter++;
                    System.out.println(f.getName());
                    queue.add(f);
                }
            }

        }

        System.out.printf("%d folders", counter);
    }
}
