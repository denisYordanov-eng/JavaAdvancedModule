import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueUsernames_01 {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       Set<String> names = new LinkedHashSet<>();
       int n = Integer.parseInt(br.readLine());


       for (int i = 0; i < n; i++) {
           String name = br.readLine();
           names.add(name);
       }
        names.forEach(System.out::println);
    }
}
