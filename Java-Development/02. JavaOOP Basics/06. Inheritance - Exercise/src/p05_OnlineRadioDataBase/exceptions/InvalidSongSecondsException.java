package p05_OnlineRadioDataBase.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {
    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
