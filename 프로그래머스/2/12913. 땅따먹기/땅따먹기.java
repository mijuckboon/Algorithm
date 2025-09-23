import java.util.*;

class Solution {
    static final int COL_COUNT = 4;
    
    int solution(int[][] land) {
        int[] scores = new int[COL_COUNT];
        int len = land.length; // try 1 -> scores.length
        
        for (int i = 0; i < len; i++) {
            int[] tmp = new int[COL_COUNT];
            
            for (int j = 0; j < COL_COUNT; j++) {
                if (i == 0) {
                    tmp[j] = land[0][j];
                    continue;
                }
                int max = -1;
                
                for (int k = 0; k < COL_COUNT; k++) {
                    if (k != j) {
                        max = Math.max(max, scores[k]);
                    }
                }
                tmp[j] = max + land[i][j];
            }
            scores = tmp;
        }

        return Arrays.stream(scores).max().orElse(0);
    }
}