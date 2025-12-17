package FilesAndStreams_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\Laptop\\Desktop\\inputText.txt";
        String outputPath = "C:\\Users\\Laptop\\Desktop\\outputText.txt";

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<Character> punctuation = new HashSet<>(Arrays.asList('.', ',', '!', '?'));

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter out = new PrintWriter(outputPath)) {
            String line = reader.readLine();

            int vowelCount = 0;
            int otherCount = 0;
            int punctuationCount = 0;

            while (line != null) {
                for (Character ch : line.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        if (vowels.contains(ch)) {
                            vowelCount++;
                        } else {
                            otherCount++;
                        }
                    } else if (punctuation.contains(ch)) {
                        punctuationCount++;
                    }
                }
                line = reader.readLine();
            }
            //Vowels: 13
            //Consonants: 17
            //Punctuation:
            out.println("Vowels: " + vowelCount);
            out.println("Consonants: " + otherCount);
            out.println("Punctuations: " + punctuationCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
