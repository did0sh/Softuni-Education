package p05_OnlineRadioDataBase.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
