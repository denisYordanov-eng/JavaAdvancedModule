package ObjectsClassesAndCollections_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class AcademyGraduation_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = readNumber(br);

        Map<String,Double> studentMarks = ReadStudentMark(br,n);

        printStudentsMarks(studentMarks);
    }

    private static void printStudentsMarks(Map<String, Double> studentMarks) {
        //order map by key and print kvp
        studentMarks
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println( entry.getKey()+ " is graduated with " + entry.getValue());
                });
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static Map<String, Double> ReadStudentMark(BufferedReader br,int n) throws IOException {
        Map<String, Double> studentMarks = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String studentName = br.readLine();

            double[] scores = Arrays.stream(br.readLine()
                    .split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double averageMark = calculateAverageMark(scores);
            studentMarks.put(studentName, averageMark);
        }
        return studentMarks;
    }

    private static double calculateAverageMark(double[] scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }
}
