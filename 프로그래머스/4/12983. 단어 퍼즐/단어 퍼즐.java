import java.util.*;
import java.util.stream.*;

class Solution {
    static final int INF = 20_001; // Integer.MAX_VALUE 사용 시 overflow 위험
        
    public int solution(String[] strs, String t) {
        int len = t.length();        
        
        int[] minWordCount = new int[len + 1];
        Arrays.fill(minWordCount, INF);
        minWordCount[0] = 0;
            
        Set<String> words = new HashSet<>(Arrays.asList(strs));
        Set<Integer> lengths = new HashSet<>();
        
        for (String str: strs) {
            lengths.add(str.length());
        }
               
        for (int i = 1; i <= len; i++) {
            
            for (int length: lengths) {
                if (i < length) {
                    continue;
                }
                // 남은 부분(substr)을 채울 수 있는 length인지 체크
                    String substr = t.substring(i - length, i);
                    
                    if (words.contains(substr)) {
                        minWordCount[i] = Math.min(minWordCount[i], minWordCount[i - length] + 1);
                    }
                
            }
              
        }
       
        return getMinimum(minWordCount[len]);
    }
    
    private int getMinimum(int number) {
        if (number < INF) {
            return number;
        }
        
        return -1;
    }
}