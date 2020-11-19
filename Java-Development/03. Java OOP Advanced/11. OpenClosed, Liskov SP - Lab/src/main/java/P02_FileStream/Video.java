package P02_FileStream;

public class Video implements Streamable {
    private int length;
    private int bytesSent;

    public Video(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }
}
