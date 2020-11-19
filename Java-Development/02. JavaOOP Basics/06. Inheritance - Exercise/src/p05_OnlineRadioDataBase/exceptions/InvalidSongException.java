package p05_OnlineRadioDataBase.exceptions;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException(String message) {
        super(message);
    }
}
