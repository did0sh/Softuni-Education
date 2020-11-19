package p05_OnlineRadioDataBase;

import p05_OnlineRadioDataBase.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Playlist playlist = new Playlist();

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split(";");
            try {
                if (info.length != 3) {
                    throw new InvalidSongException("Invalid song.");
                }
                String artist = info[0];
                String song = info[1];
                String songLength = info[2];

                Song song1 = new Song(artist, song, songLength);
                playlist.addSong(song1);
                System.out.printf("Song added.%n");

            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        System.out.printf("Songs added: %d%n", playlist.getSongs().size());
        playlist.calcTotalPlaylistLength();
    }
}
