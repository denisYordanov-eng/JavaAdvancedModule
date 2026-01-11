package StringProcessing_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalSumInMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n][n];
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            String[] input =  br.readLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
            leftSum+= matrix[i][i];
        }
        for (int i = 0; i < n; i++) {
            rightSum+= matrix[i][n-1 - i];
        }

        int result = Math.abs(leftSum - rightSum);
        System.out.println(result);
        
    }
}
