import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.concurrent.*;

public class DirectorySizeAsync {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the first directory: ");
        String firstDirectory = br.readLine();
        System.out.println();
        System.out.print("Enter the second directory: ");
        String secondDirectory = br.readLine();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Long> firstFileSize = executor.submit(() -> findLengthOfDirectory(firstDirectory));
        Future<Long> secondFileSize = executor.submit(() -> findLengthOfDirectory(secondDirectory));

        printSize(firstFileSize);
        printSize(secondFileSize);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

    }

    private static void printSize(Future<Long> fileSize) throws ExecutionException, InterruptedException {
        long size = fileSize.get();
        if (size <= 0) {
            System.out.println("The folder is empty!");
        } else {
            double mbSize = calculateResultInMegabytes(size);
            System.out.printf("The size of directory is: %.2fMB%n", mbSize);
        }
    }

    private static double calculateResultInMegabytes(long result) {
        return (double) result / (1024.0 * 1024.0);
    }

    public static long findLengthOfDirectory(String path) throws IOException {
        long totalSize = 0;
        //initialize a stack of Files
        ArrayDeque<File> stack = new ArrayDeque<>();
        stack.push(new File(path));
        while (!stack.isEmpty()) {
            //get the last file
            File currentFile = stack.pop();
            // make file array of currentFile with method listFiles()
            File[] files = currentFile.listFiles();
            //check if files are not null
            if (files != null) {
                //make a while loop
                for (File file : files) {
                    //check if file is directory if is directory make a push current file to stack to make array of files
                    if (file.isDirectory()) {
                        stack.push(file);
                    } else {
                        //if it is not a directory add the size  ofi the file
                        totalSize += file.length();
                    }
                }
            }
        }
        return totalSize;
    }
}

