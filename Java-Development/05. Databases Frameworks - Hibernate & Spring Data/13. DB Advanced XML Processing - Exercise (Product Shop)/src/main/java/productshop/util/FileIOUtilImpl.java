package productshop.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
