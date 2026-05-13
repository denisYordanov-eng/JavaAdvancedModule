package Interfaces;

import javax.naming.OperationNotSupportedException;

public interface ListCommands<T> {
    boolean move() throws OperationNotSupportedException;
    boolean hasNext() throws OperationNotSupportedException;
    void print() throws OperationNotSupportedException;
    int getCurrentIndex();
}
