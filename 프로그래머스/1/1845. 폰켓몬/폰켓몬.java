import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // Set<Integer> types = new HashSet<>(Arrays.toList(nums));
        Set<Integer> types = new HashSet<>();
        Arrays.stream(nums).forEach(x -> types.add(x));
        
        return Math.min(types.size(), nums.length / 2);
    }
}