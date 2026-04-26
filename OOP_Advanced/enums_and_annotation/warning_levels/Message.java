package warning_levels;

public class Message {
    private Importance level;
    private String message;

    public Message(Importance level, String message) {
        this.level = level;
        this.message = message;
    }

    @Override
    public String toString() {
        return level + ": " + message;
    }
}
