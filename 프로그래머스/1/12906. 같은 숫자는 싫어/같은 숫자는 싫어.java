import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> shrinked = new ArrayList<>();
        shrinked.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int prev = arr[i - 1];
            int current = arr[i];
            if (prev != current) {
                shrinked.add(current);
            }
        }
        
        return shrinked.stream().mapToInt(x -> x).toArray();
    }
}