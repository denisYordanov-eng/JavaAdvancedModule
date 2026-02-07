package random_arraylist;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<Object> extends ArrayList {
    Random rand = new Random();

    public Object getRandomElement(){
        int index = rand.nextInt(super.size() - 1);
       Object element = (Object) super.remove(index);
       return element;
    }

}
