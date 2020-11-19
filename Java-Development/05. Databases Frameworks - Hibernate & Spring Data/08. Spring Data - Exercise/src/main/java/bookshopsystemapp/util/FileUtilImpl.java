package bookshopsystemapp.util;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtilImpl implements FileUtil {
    @Override
    public String[] getFileContent(String path) throws IOException {
        File file = new File(path);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();

        String line;
        while ((line = bufferedReader.readLine()) != null){
            lines.add(line);
        }
        return lines.stream().filter(l -> !l.equals("")).toArray(String[]::new);
    }
}
