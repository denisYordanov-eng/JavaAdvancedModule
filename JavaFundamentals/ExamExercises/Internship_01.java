package JavaAdvancedExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Internship_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int problemsCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());

        ArrayDeque<String> problemsStack = fillStack(reader, problemsCount);
        ArrayDeque<String> candidatesQueue = fillQueue(reader, candidatesCount);

        while (!candidatesQueue.isEmpty()) {

            if (problemsStack.isEmpty()) {
                String currentCandidates = candidatesQueue.toString()
                        .replace("[", "")
                        .replace("]", "");
                System.out.println(currentCandidates);
                break;
            }
            if (candidatesQueue.size() == 1) {
                String currentCandidate = candidatesQueue.poll();
                System.out.printf("%s gets the job!%n", currentCandidate);
                break;
            }
            String currentProblem = problemsStack.pop();
            String currentCandidate = candidatesQueue.poll();

            int currentProblemsPoints = calculatePoints(currentProblem);
            int currentCandidatesPoints = calculatePoints(currentCandidate);

            if (currentCandidatesPoints > currentProblemsPoints) {
                System.out.printf("%s solved %s.%n", currentCandidate, currentProblem);
                candidatesQueue.offer(currentCandidate);
            } else {
                System.out.printf("%s failed %s.%n", currentCandidate, currentProblem);
                problemsStack.addLast(currentProblem);
            }
        }
    }

    private static int calculatePoints(String currentString) {
        int sum = 0;
        for (int i = 0; i < currentString.length(); i++) {
            sum += (int) currentString.charAt(i);
        }
        return sum;
    }

    public static ArrayDeque<String> fillQueue(BufferedReader reader, int candidatesCount) throws IOException {
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < candidatesCount; i++) {
            String currentName = reader.readLine();
            boolean isCorrect = checkIsCorrect(currentName);
            if (isCorrect) {
                queue.offer(currentName);
            }
        }
        return queue;
    }

    public static ArrayDeque<String> fillStack(BufferedReader reader, int problemsCount) throws IOException {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < problemsCount; i++) {
            String currentProblem = reader.readLine();
            stack.push(currentProblem);
        }
        return stack;
    }

    private static boolean checkIsCorrect(String currentName) {
        String regexPattern = "([A-Z][a-z]+) ([A-Z][a-z]+)";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(currentName);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
