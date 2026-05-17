package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BiFunction;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> implements ExtendedArrayListable<T> {
    @Override
    public T min() {
        BiFunction<T, T, Boolean> functionMin = (a, b) -> a.compareTo(b) > 0;
        return getMaxOrMin(functionMin);
    }

    @Override
    public T max() {
        BiFunction<T, T, Boolean> functionMax = (a, b) -> a.compareTo(b) < 0;
        return getMaxOrMin(functionMax);
    }

    private T getMaxOrMin(BiFunction<T, T, Boolean> function) {
        T maxOrMin = null;
        Iterator<T> iterator = super.iterator();
        while (iterator.hasNext()) {
            T nextElement = iterator.next();
            if (maxOrMin == null || function.apply(maxOrMin, nextElement)) {
                maxOrMin = nextElement;
            }
        }
        return maxOrMin;
    }
}

