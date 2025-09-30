import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int deptCount = 0;
        int support = 0;
        Arrays.sort(d);
        
        for (int request: d) {
            if (support > budget) {
                break;
            }
            
            if (support + request <= budget) {
                support += request;
                deptCount += 1;
            }
        }
              
        return deptCount;
    }
}