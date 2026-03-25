package shapes_drawing;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            queue.add(Integer.parseInt(scanner.nextLine()));
        }
    if(!queue.isEmpty()){
            Drawable circle = new Circle(queue.poll());
            Drawable rect = new Rectangle(queue.poll(), queue.poll());

            circle.draw();
            rect.draw();
        }
    }
}
