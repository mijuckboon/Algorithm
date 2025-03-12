import java.io.*;
import java.util.*;

public class Main {
   
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int countCity = Integer.parseInt(br.readLine());
            final long[] distances = new long[countCity - 1];
            final long[] prices = new long[countCity];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < countCity - 1; i++) {
                distances[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < countCity; i++) {
                prices[i] = Long.parseLong(st.nextToken());
            }
            
            long totalCost = 0;
            long current = 1_000_000_000;
            for (int i = 0; i < countCity - 1; i++) {
                current = Math.min(current, prices[i]);
                totalCost += current * distances[i];
            }
            
            System.out.println(totalCost);
        }
    }
}