package Abstraction_Exercises;


import java.util.Scanner;

public class SequenceInMatrix_05 {
   private static int bestSequence = 1;
  private static String bestSequenceString = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = inputLine[j];
            }
        }
        bestSequenceString = matrix[0][0];

        checkDiagonals(n,m,matrix);

        checkRows(n,m,matrix);

        checkCols(n,m,matrix);

        printResult(bestSequence,bestSequenceString);
    }
    private  static void printResult(int bestSequence,String bestSequenceString){
        for (int i = 0; i < bestSequence; i++) {
            if(i == bestSequence-1){
                System.out.println(bestSequenceString);
            }else {
                System.out.print(bestSequenceString + ", ");
            }
        }
    }

    private static void checkCols(int n, int m, String[][] matrix) {
        for(int j = 0; j < m; j++) {
            int count = 1;
            for (int i = 0; i < n - 1; i++){
                if (matrix[i][j].equals(matrix[i+1][j])){
                    count++;
                }else {
                    updateSequence(count, matrix[i][j]);
                    count = 1;
                }
            }
            if (n > 0){
                updateSequence(count, matrix[n-1][j]);
            }
        }
    }

    private static void checkRows(int n, int m, String[][] matrix) {
        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = 0; j < m - 1; j++) {
                if(matrix[i][j].equals(matrix[i][j + 1])){
                    count++;
                }else {
                    updateSequence(count,matrix[i][j]);
                    count = 1;
                }

            }
            if (m > 0){
                updateSequence(count,matrix[i][m - 1]);
            }
        }
    }

    private static void checkDiagonals(int n, int m, String[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String currentString = matrix[i][j];

                int count = 1;
                for (int k = 1; i + k < n && j + k < m  ; k++) {
                        if(currentString.equals(matrix[i + k][j + k])){
                            count++;
                        }else {
                            break;
                        }
                }
                updateSequence(count,currentString);
                count = 1;
                for(int k = 1; i + k< n && j - k >= 0 ; k++) {
                    if(currentString.equals(matrix[i + k][j - k])){
                        count++;
                    }else  {
                        break;
                    }
                    updateSequence(count,currentString);
                }
            }
        }
    }

    private static void updateSequence(int currentLength, String value) {
        if(currentLength >= bestSequence){
            bestSequence = currentLength;
             bestSequenceString = value;
        }
    }
}