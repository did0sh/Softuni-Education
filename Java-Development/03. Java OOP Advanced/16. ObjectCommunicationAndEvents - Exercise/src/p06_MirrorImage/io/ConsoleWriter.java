package p06_MirrorImage.io;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
