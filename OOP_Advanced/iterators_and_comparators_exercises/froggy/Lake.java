package froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake<T extends Integer> implements Iterable<Integer> {
    private List<Integer> numbers;

    public Lake(Integer... numbers) {
        this.numbers = Arrays.asList(numbers);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        private int index;


        public Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < numbers.size();
        }

        @Override
        public Integer next() {
            int current = this.index;
            if (this.index + 2 < numbers.size()) {
                this.index += 2;
                //loop through odd numbers first
            } else if (this.index % 2 == 0) {
                //if current index is even set the index to 1 end iterate to the end
                index = 1;
            } else {
                index += 2;
            }
            return numbers.get(current);
        }

    }
}
