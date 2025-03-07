import java.util.*;
import java.io.*;

public class Main {
    static class Jewel {
        int weight;
        int value;
        
        Jewel (int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int countJewel = Integer.parseInt(st.nextToken());
            int countBag = Integer.parseInt(st.nextToken());
            
            PriorityQueue<Jewel> jewels = new PriorityQueue<>(
                Comparator.comparing( (Jewel jewel) -> jewel.weight )
                        .thenComparing( (Jewel jewel) -> -jewel.value )
        );
            
            for (int i = 0; i < countJewel; i++) {
                st = new StringTokenizer(br.readLine());
                jewels.offer(new Jewel(
                    Integer.parseInt(st.nextToken())             
                                        , Integer.parseInt(st.nextToken())));
            }
            
            PriorityQueue<Integer> bags = new PriorityQueue<>();
            for (int i = 0; i < countBag; i++) {
                bags.offer(Integer.parseInt(br.readLine()));
            }
            
            PriorityQueue<Jewel> availableJewels = new PriorityQueue<>(
                Comparator.comparing( (Jewel jewel) -> -jewel.value));
            
            long totalValue = 0;
            
            while (!bags.isEmpty()) {
            int capacity = bags.poll();

            while (!jewels.isEmpty() && jewels.peek().weight <= capacity) {
                    availableJewels.offer(jewels.poll());
            }

            Jewel availableJewel = availableJewels.poll();
            if (availableJewel != null) {
                totalValue += availableJewel.value;
            }
        }
            System.out.println(totalValue);
            
        }
    }
    
}