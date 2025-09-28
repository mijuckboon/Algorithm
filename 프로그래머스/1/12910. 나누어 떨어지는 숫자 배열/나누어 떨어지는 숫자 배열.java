import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] filtered = Arrays.stream(arr)
            .filter(x -> x % divisor == 0)
            .sorted()
            .toArray();
        
        return filtered.length > 0? filtered : new int[] {-1};
    }
}