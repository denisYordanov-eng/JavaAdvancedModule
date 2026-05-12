package interfaces;

import javax.naming.OperationNotSupportedException;

public interface Databaseable {
    void add(Integer element) throws OperationNotSupportedException;
    void remove() throws OperationNotSupportedException;
    Integer[] fetch () throws OperationNotSupportedException;
}
