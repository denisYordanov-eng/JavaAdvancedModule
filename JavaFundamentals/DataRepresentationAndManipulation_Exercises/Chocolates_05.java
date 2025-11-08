package DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chocolates_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //read number of packets
        int numberOfPackets = readNumber(br);

        //read all packets in array
        int[] allPackets = readArrPackets(br);

        //read all students
        int numberOfStudents = readNumber(br);

        //sort arr
        sortArr(allPackets);

        //find min diff
        int minDiff = findMinDiff(allPackets, numberOfStudents, numberOfPackets);

        //print min diff
        printOutput(minDiff);

    }

    private static void printOutput(int minDiff) {
        System.out.printf("Min Difference is %d.%n", minDiff);
    }

    private static int findMinDiff(int[] sortedArray, int numberOfStudents, int numberOfPackets) {
        //initialize minDiff
        int minDiff = Integer.MAX_VALUE;
        //initialize a for loop and make a frame watching a number of elements equals of number of students
        for (int i = 0; i + numberOfStudents - 1 < numberOfPackets; i++) {
            //calculate subtract between the last element and the first element of the frame
            int diff = sortedArray[i + numberOfStudents - 1] - sortedArray[i];
            //check if current difference is smaller than Min diff
            if (diff < minDiff) {
                //if it's true make minDiff equals to diff
                minDiff = diff;
            }
        }
        //return min diff
        return minDiff;
    }

    private static void sortArr(int[] allPackets) {
        //sort all packets to compare easy elements inside all packets
        Arrays.sort(allPackets);
    }

    private static int[] readArrPackets(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine()
                        .split("[\\s,]+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
