import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Scanner;

public class p04_ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String inputhFile = "C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\input.txt";
        String outputhFile = "C:\\Users\\user\\IdeaProjects\\01. Java Advanced\\07. FilesAndDirectories - Lab\\src\\Files-and-Streams\\output3.txt";

        try(Scanner scan = new Scanner(new FileInputStream(inputhFile))){
            PrintWriter out = new PrintWriter(new FileOutputStream(outputhFile));
            while (scan.hasNext()){
                if (scan.hasNextInt()){
                   out.println(scan.nextInt());
                }
                scan.next();
            }
            out.flush();
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
