package P02_FileStream;

public class Main {
    public static void main(String[] args) {
        Streamable music = new Music(100, 10);
        Streamable video = new Video(120, 30);

        StreamProgressInfo spi = new StreamProgressInfo(music);
        StreamProgressInfo spi2 = new StreamProgressInfo(video);

        System.out.println(spi.calculateCurrentPercent());
        System.out.println(spi2.calculateCurrentPercent());
    }
}
