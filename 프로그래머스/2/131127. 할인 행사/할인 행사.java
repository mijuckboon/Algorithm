import java.util.*;
class Solution {
    static final int LEN = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;
        
        Map<String, Integer> desired = new HashMap<>();
        Map<String, Integer> searched = new HashMap<>();
        for (int i = 0; i < number.length; i++) {
            desired.put(want[i], number[i]);
            // if (searched.containsKey(discount[i])) {
                
            // }
        }
        
        for (int i = 0; i < LEN; i++) {
            searched.put(discount[i], searched.getOrDefault(discount[i], 0) + 1);
        }
        
        for (int i = 0; i < discount.length - LEN; i++) {
            if (desired.equals(searched)) { count += 1; }
            if (searched.containsKey(discount[i])) {
            // if (desired.containsKey(discount[i]) && searched.containsKey(discount[i])) {
                int value = searched.get(discount[i]);
                if (value == 1) { searched.remove(discount[i]); }
                else { searched.put(discount[i], value - 1); }
            }
            // if (desired.containsKey(discount[i + LEN])) {
                searched.put(discount[i + LEN], searched.getOrDefault(discount[i + LEN], 0) + 1);
            // }
        }
        if (desired.equals(searched)) { count += 1; }
             
        
        return count;  
    }
}