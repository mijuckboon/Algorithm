import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizes = new HashMap<>();
        for (int tangerineSize : tangerine) {
            sizes.put(tangerineSize, sizes.getOrDefault(tangerineSize, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(sizes.values()); // keySet, values(Collection), entrySet
        counts.sort(Comparator.reverseOrder());
        
        int sizesCount = 0;
        for (int count : counts) {
            k -= count;
            sizesCount += 1;
            
            if (k <= 0) {
                break;
            }
        }
        
        return sizesCount;
    }
}