package DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestedLoopsToRecursion_02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //read number from the console using bufferedReader br because it's faster than scanner
        int n = Integer.parseInt(br.readLine());
        // check if number is smaller or equal of 0
        //if it's smaller return the program
        if(n <= 0){
            return;
        }
        //initialize an array of integers, n length
        int[] arr = new int[n];
        //call the nested loop method and set as parameters n, initial index of 0, arr
        nestedLoop(n,0, arr);

    }

    private static void nestedLoop(int number, int index, int[] arr) {
        // the base condition when all positions are filled then call the method printArr and return
        if(index == number) {
            printArr(arr, number);
            return;
        }
            //made a for loop and set the element of the index
        for(int j = 1; j <= number; j++) {
            arr[index] = j;
            //call again recursively to simulate nested loop but add to index 1
            nestedLoop(number,index + 1, arr);
        }
    }

    private static void printArr(int[] arr,int n) {
        //initialize stringBuilder sb
        StringBuilder sb = new StringBuilder();
        //make a foreach and add to sb element and space
        for(int element : arr ) {
           sb.append(element).append(" ");
        }
        //print the current output
        System.out.println(sb.toString());
    }
}
