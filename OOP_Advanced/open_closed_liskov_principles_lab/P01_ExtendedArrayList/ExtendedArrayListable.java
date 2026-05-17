package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.List;

public interface ExtendedArrayListable<T> extends List<T> {
    T min();

    T max();
}
