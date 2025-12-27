import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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


        Future<Long> future = executor.submit(() -> findLengthOfDirectory(firstDirectory));
        Future<Long> secondFuture = executor.submit(() -> findLengthOfDirectory(secondDirectory));

       printResult(future);
       printResult(secondFuture);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

    }

    private static void printResult(Future<Long> future) throws ExecutionException, InterruptedException {
     long result = future.get();
     double resultInMegaBytes = calculateResultInMegabytes(result);
     if(result > 0){
         System.out.println("Directory is " + resultInMegaBytes + " MB");
     } else {
         System.out.println("Directory not found!");
     }
    }

    private static double calculateResultInMegabytes(long result) {
        return (double) result / (1024.0 * 1024.0);
    }

    public static long findLengthOfDirectory(String path) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            return -1;
        }

        long length = 0;
        if(file.isDirectory()){
            File[] files = file.listFiles();
            if(files != null){
                for(File f : files){
                    if(!f.isDirectory()){
                       length += f.length();
                    }
                }
            }
        }
        return length;
    }


}

