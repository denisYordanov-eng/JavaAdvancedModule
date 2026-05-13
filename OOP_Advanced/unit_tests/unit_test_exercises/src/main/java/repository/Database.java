package repository;

import interfaces.Databaseable;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Database implements Databaseable<Integer> {
    private Integer[] arr;
    int arrSize;

    public Integer[] getArr() {
        return this.arr;
    }

    public Database(Integer... arr) throws OperationNotSupportedException {
        this.arr = new Integer[16];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = arr[i];
        }
        this.arrSize = arr.length;
        if (this.arrSize != 16) {
            throw new OperationNotSupportedException("Wrong database length!");
        }
    }


    @Override
    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException("The adding value cannot be null!");
        }
        if (this.arrSize >= 16) {
            throw new OperationNotSupportedException("The dataBase is full!");
        }

        arr[arrSize++] = element;


    }

    @Override
    public void remove() throws OperationNotSupportedException {
        if (this.arrSize == 0) {
            throw new OperationNotSupportedException("The database is empty!");
        }
        arr[--arrSize] = null;

    }

    @Override
    public Integer[] fetch() throws OperationNotSupportedException {
        if (this.arrSize == 0) {
            throw new OperationNotSupportedException("The database is empty!");
        }
        Integer[] result = new Integer[arrSize];
        System.arraycopy(arr, 0, result, 0, arrSize);

        return result;
    }
}
