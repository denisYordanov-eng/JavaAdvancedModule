package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class SimpleTextEditor_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = readNumber(br);

        StringBuilder text = new StringBuilder();

        ArrayDeque<String> history = new ArrayDeque<>();

        fillAndManipulateText(history, n, br,text);
    }

    private static void fillAndManipulateText(ArrayDeque<String> history, int n, BufferedReader br,StringBuilder text) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] input = readCommands(br);
            String command = input[0];
            switch (command) {
                case "1": //append new text
                    String  currentText = input[1];
                    history.push(text.toString());
                    text.append(currentText);
                    break;
                case "2": //remove text and safe in history removed text
                    int removeCount = Integer.parseInt(input[1]);
                    history.push(text.toString());
                    text.delete(text.length() - removeCount, text.length());
                    break;
                case "3": // find target char and print it
                    int targetNumber = Integer.parseInt(input[1]);
                    System.out.println(text.charAt(targetNumber - 1));
                    break;
                case "4": //undo the last operation using history
                    String previousText = history.pop();
                    text.setLength(0);
                    text.append(previousText);
                    break;
            }
        }
    }

    private static String[] readCommands(BufferedReader br) throws IOException {
        return br.readLine().split("\\s+");
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
