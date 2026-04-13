package generic_count_method_doubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < n; i++) {
            double currentNumer = Double.parseDouble(br.readLine());
            list.add(currentNumer);
        }
        double targetNumber = Double.parseDouble(br.readLine());
        int count =Box.compareCount(list,targetNumber);
        System.out.println(count);
    }
}
