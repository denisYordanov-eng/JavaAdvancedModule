package warning_levels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message> message;
    private Importance type;


    public Logger(Importance type) {
        this.type = type;
        this.message = new ArrayList<>();
    }

    public void receivesMessage(Importance importance, String message) {
        if (this.type.getValue() <= importance.getValue()) {
            this.message.add(new Message(importance, message));
        }
    }

    public Iterable<Message> getMessages() {
        return this.message;
    }
}

