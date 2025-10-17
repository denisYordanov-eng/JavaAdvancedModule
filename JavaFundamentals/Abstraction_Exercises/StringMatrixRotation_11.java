package Abstraction_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputCommand = scanner.nextLine();
        String regex ="Rotate\\((\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputCommand);

        int rotation = 0;
        if(matcher.matches()){
            rotation = Integer.parseInt(matcher.group(1));
        }
        rotation = rotation % 360;
        List<char[]> inputLines = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            inputLines.add(input.toCharArray());
        }
        switch (rotation) {
            case 90:
                rotateNinetyDegree(inputLines);
                break;
            case 180:
                rotateHundredAndEightyDegree(inputLines);
                break;
            case 270:
                rotateTwoHundredAndSeventyDegree(inputLines);
                break;
            default:
                for(char[] line : inputLines){
                    System.out.println(line);
            }
                break;
        }
    }

    private static void rotateTwoHundredAndSeventyDegree(List<char[]> inputLines) {
        int rows = inputLines.size();
        int cols = 0;
        for(char[] line: inputLines){
            cols = Math.max(cols, line.length);
        }
        for (int i = cols - 1; i >= 0; i--) {
            for (int j = 0;j < rows;j++) {
                char[] row = inputLines.get(j);
                if(i < row.length){
                    System.out.print(row[i]);
                }else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    private static void rotateHundredAndEightyDegree(List<char[]> inputLines) {
        for (int i = 0; i < inputLines.size(); i++) {
           for (int j = inputLines.get(inputLines.size()- 1 - i).length - 1; j >= 0; j--) {
               System.out.print(inputLines.get(inputLines.size()- 1 - i)[j]);
           }
            System.out.println();
        }
    }

    private static void rotateNinetyDegree(List<char[]> inputLines) {
        int rows = inputLines.size();
        int cols = 0;
        for(char[] line : inputLines){
            cols = Math.max(cols, line.length);
        }

        for (int i = 0; i < cols ; i++) {
            for (int j = rows- 1; j >= 0; j--) {
                   char[] row =  inputLines.get(j);
                   if(i < row.length){
                       System.out.print(row[i]);
                   }else {
                       System.out.print(' ');
                   }
            }
            System.out.println();
        }
    }
}
