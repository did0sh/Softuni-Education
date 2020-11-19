package P02_FileStream;

public class StreamProgressInfo {
    private Streamable source;

    // If we want to stream a music file, we can't
    public StreamProgressInfo(Streamable source) {
        this.source = source;
    }

    public int calculateCurrentPercent() {
        return (this.source.getBytesSent() * 100) / this.source.getLength();
    }
}
