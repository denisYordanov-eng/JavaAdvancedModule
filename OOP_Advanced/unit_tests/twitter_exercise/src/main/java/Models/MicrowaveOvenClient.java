package Models;

import Interfaces.Clientable;
import Interfaces.Tweetable;

import javax.naming.OperationNotSupportedException;

public class MicrowaveOvenClient implements Clientable {
    @Override
    public void receiveTweet(Tweetable tweet) throws OperationNotSupportedException {
        if(tweet.tweeterMessage() == null || tweet.tweeterMessage().isEmpty()) {
            throw new OperationNotSupportedException("Invalid Tweet!");
        }
        System.out.println(tweet);
        sendToServer(tweet);
    }
    private void sendToServer(Tweetable tweet) {

    }
}
