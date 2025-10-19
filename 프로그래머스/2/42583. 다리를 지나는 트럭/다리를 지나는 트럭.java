import java.util.*;

class Solution {
    private class Truck {
        int weight;
        int remainingLength;

        public Truck(int weight, int remainingLength) {
            this.weight = weight;
            this.remainingLength = remainingLength;
        }
        
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int second = 0;
        Queue<Truck> trucks = new ArrayDeque<>();
        
        for (int truckWeight: truck_weights) {
            Truck truck = new Truck(truckWeight, bridge_length);
            trucks.offer(truck);
        }
        
        Queue<Truck> bridge = new ArrayDeque<>();
        int currentWeight = 0;
        
        while (!trucks.isEmpty() || !bridge.isEmpty()) {
            second += 1;
            
            for (Truck truck: bridge) { // 이 부분이 아래 if 문보다 먼저 와야 함
                truck.remainingLength -= 1;
                
                if (truck.remainingLength == 0) {
                    bridge.poll();
                    currentWeight -= truck.weight;
                }
            }
            
            if (!trucks.isEmpty() && currentWeight + trucks.peek().weight <= weight) {
                Truck truck = trucks.poll();
                bridge.offer(truck);
                currentWeight += truck.weight;
            }
            
        }
        
        return second;
    }
}