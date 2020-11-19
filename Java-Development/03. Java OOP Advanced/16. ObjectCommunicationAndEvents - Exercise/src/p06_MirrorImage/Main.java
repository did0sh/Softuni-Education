package p06_MirrorImage;

import p06_MirrorImage.core.Engine;
import p06_MirrorImage.io.ConsoleReader;
import p06_MirrorImage.io.ConsoleWriter;
import p06_MirrorImage.io.Reader;
import p06_MirrorImage.io.Writer;
import p06_MirrorImage.models.Repository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Repository repository = new Repository();
        Engine engine = new Engine(writer, reader, repository);
        engine.run();
    }
}
