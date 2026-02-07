package stack_of_strings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(element);
    }

    public String pop() {
        if (!this.data.isEmpty()) {
            return this.data.remove(this.data.size() - 1);
        }
        throw new IllegalArgumentException("Stack is empty");
    }

    public String peek() {
        if (!this.data.isEmpty()) {
            return this.data.get(this.data.size() - 1);
        }
        throw new IllegalArgumentException("Stack is empty");
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
