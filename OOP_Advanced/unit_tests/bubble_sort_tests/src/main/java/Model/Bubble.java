package Model;

import Interface.BubbleSortable;

import java.util.List;

public class Bubble implements BubbleSortable {
    private List<Integer> list;

    public Bubble(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("list is null or empty");
        }
        this.list = list;
    }
    @Override
    public List<Integer> bubbleSort() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (this.list.get(i) > this.list.get(i + 1)) {
                    int temp = list.get(i);
                    this.list.set(i, list.get(i + 1));
                    this.list.set(i + 1, temp);
                    swapped = true;
                }
            }
        }while(swapped);
        return this.list;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.list.size(); i++) {
            sb.append(this.list.get(i));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
