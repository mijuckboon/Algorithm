import java.util.*;
import java.io.*;

public class Main {
    static class Truck {
        int weight;
        int remainingDistance;

        public Truck(int weight, int remainingDistance) {
            this.weight = weight;
            this.remainingDistance = remainingDistance;
        }
    }
    
    public static void main(String[] args) throws IOException {
    
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] truckWeight = new int[n];
        for (int i = 0; i < n; i++) {
            truckWeight[i] = Integer.parseInt(st.nextToken());
        }        
       System.out.println(solution(w, l, truckWeight));
    }
       
    }
    public static int solution(int w, int l, int[] truckWeight) {
        Queue<Truck> trucks = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();

        for (int i = 0; i < truckWeight.length; i++) {
            trucks.offer(new Truck(truckWeight[i], w));
        }

        int time = 0;
        int acceptableWeight = l;

        while (!trucks.isEmpty() || !bridge.isEmpty()) {
            Iterator<Truck> iterator = bridge.iterator();
            while (iterator.hasNext()) {
                Truck ridingTruck = iterator.next();
                ridingTruck.remainingDistance -= 1;
                if (ridingTruck.remainingDistance == 0) {
                    acceptableWeight += ridingTruck.weight;
                    iterator.remove();
                }
            }

            if (!trucks.isEmpty()) {
                Truck truck = trucks.peek();
                if (truck.weight <= acceptableWeight) {
                    trucks.poll();
                    bridge.offer(truck);
                    acceptableWeight -= truck.weight;
                }
            }
            time += 1;
        }
        return time;
        }
}