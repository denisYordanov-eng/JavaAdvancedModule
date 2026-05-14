package Models;

import Interfaces.Tweetable;

import javax.naming.OperationNotSupportedException;


public class Tweet implements Tweetable {
    private String message;
    public Tweet(String message) throws OperationNotSupportedException {
        if (message == null || message.isEmpty()) {
            throw new OperationNotSupportedException("Message cannot be null or empty");
        }
        this.message = message;
    }
    @Override
    public String tweeterMessage() throws OperationNotSupportedException {
        return this.message;
    }
}
