package generic_array_creator;

import java.lang.reflect.Array;

public class ArrayCreator<T> {

    @SuppressWarnings("unchecked")
    public static  <T> T[] create(int length, T item) {
        T[] array = (T[]) new Object[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public static  <T> T[] create(Class<T> c, int length, T item) {
        T[] array = (T[]) Array.newInstance(c, length);
        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }
}
