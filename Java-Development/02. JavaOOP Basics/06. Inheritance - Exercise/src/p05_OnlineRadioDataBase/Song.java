package p05_OnlineRadioDataBase;

import p05_OnlineRadioDataBase.exceptions.*;

public class Song {
    private String artistName;
    private String songName;
    private String duration;

    public Song(String artistName, String songName, String duration)  {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setDuration(duration);
    }

    private void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 30){
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setDuration(String duration) {
        int seconds = 0;
        int minutes = 0;
        try {
            minutes = Integer.parseInt(duration.split(":")[0]);
            seconds = Integer.parseInt(duration.split(":")[1]);
        } catch (IllegalArgumentException ex){
            throw new InvalidSongLengthException("Invalid song length.");
        }

        if (minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }

        if (seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }

        this.duration = duration;
    }

    public int getDuration(){
        int total = 0;
        String[] tokens = this.duration.split(":");
        int minutes = Integer.parseInt(tokens[0]);
        int seconds = Integer.parseInt(tokens[1]);
        total += minutes*60 + seconds;
        return total;
    }

}
