import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class p08_MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder text = new StringBuilder(input);

        String pattern = reader.readLine();
        StringBuilder sb = new StringBuilder(pattern);

        StringBuilder results = new StringBuilder();

        int indexFirst = text.indexOf(pattern);
        int indexLast = text.lastIndexOf(pattern);

        while (text.length() > 0 && pattern.length() > 0) {
            if (indexFirst > -1 && indexLast > -1 && indexFirst != indexLast) {

                indexFirst = text.indexOf(pattern);
                text = text.delete(indexFirst, indexFirst + pattern.length());
                indexLast = text.lastIndexOf(pattern);
                text = text.delete(indexLast, indexLast + pattern.length());

                results.append("Shaked it." + System.lineSeparator());
                pattern = (sb.deleteCharAt(pattern.length()/2)).toString();

                indexFirst = text.indexOf(pattern);
                indexLast = text.lastIndexOf(pattern);

            } else {
                break;
            }
        }
        System.out.print(results.toString());
        System.out.println("No shake.");
        System.out.println(text);

    }
}
