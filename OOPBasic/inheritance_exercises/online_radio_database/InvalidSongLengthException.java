package online_radio_database;

public class InvalidSongLengthException extends  InvalidSongException {
    public InvalidSongLengthException() {
        super("Invalid song length.");
    }

    public InvalidSongLengthException(String message) {
        super(message);
    }
}
