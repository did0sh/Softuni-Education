package chushka.util;

import java.io.*;

public class HtmlReader {

    public String readHtmlFile(String htmlFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(htmlFilePath)
                        )
                )
        );

        String line;
        StringBuilder htmlFileContent = new StringBuilder();
        while ((line = reader.readLine()) != null){
            htmlFileContent.append(line).append(System.lineSeparator());
        }

        return htmlFileContent.toString().trim();
    }
}
