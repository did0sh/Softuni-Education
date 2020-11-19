import java.io.*;

public class p05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\input.txt";
        String outputFile = "C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\Files-and-Streams\\output4.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(inputFile))){
            PrintWriter out = new PrintWriter(new FileWriter(outputFile));
            long countLines = 0;

            String line = in.readLine();
            while (line != null) {
                countLines++;
                if (countLines % 3 == 0) {
                    out.println(line);
                }
                line = in.readLine();
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
