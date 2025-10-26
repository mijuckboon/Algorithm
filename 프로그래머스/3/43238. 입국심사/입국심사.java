import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = Arrays.stream(times).max().orElse(0) * (long) n;
        long minTime = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            // map은 IntStream
            long totalCheck = Arrays.stream(times).mapToLong(time -> mid / time).sum();
            
            if (totalCheck >= n) {
                minTime = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return minTime;
    }

}