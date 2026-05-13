package interfaces;

import javax.naming.OperationNotSupportedException;

public interface Databaseable<T> {
    void add(T element) throws OperationNotSupportedException;
    void remove() throws OperationNotSupportedException;
    T[] fetch () throws OperationNotSupportedException;
}
