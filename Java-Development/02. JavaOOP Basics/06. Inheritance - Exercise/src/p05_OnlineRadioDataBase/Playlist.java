package p05_OnlineRadioDataBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private List<Song> songs;
    private int length;

    public Playlist(){
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void calcTotalPlaylistLength(){
        for (Song song : this.songs) {
            this.length += song.getDuration();
        }

        int hours = this.length / 3600;
        int minutes = (this.length % 3600) / 60;
        int seconds = (this.length % 3600) % 60;

        System.out.printf("Playlist length: %dh %dm %ds%n", hours, minutes, seconds);
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(this.songs);
    }
}
