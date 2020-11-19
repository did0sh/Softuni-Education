package realestate.util;

import java.io.*;

public class HtmlReader {

    public String readHtmlFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder htmlFileContent = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null){
            htmlFileContent.append(line).append(System.lineSeparator());
        }

        return htmlFileContent.toString();
    }
}
