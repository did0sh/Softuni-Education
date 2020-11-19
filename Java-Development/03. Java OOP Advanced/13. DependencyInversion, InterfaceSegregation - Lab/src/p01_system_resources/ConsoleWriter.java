package p01_system_resources;

public class ConsoleWriter implements Writer {
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
