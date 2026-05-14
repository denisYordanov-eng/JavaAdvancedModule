package Interfaces;

import javax.naming.OperationNotSupportedException;

public interface Tweetable {
    String tweeterMessage() throws OperationNotSupportedException;
}
