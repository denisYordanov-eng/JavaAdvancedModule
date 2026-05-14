package Interfaces;

import javax.naming.OperationNotSupportedException;

public interface Clientable {
    void receiveTweet(Tweetable tweet) throws OperationNotSupportedException;
}
