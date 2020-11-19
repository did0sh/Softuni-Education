package cardealer.util;

import java.io.*;

public class FileIOUtilImpl implements FileIOUtil {
    @Override
    public String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null){
            sb.append(line);
        }
        return sb.toString();
    }
}
