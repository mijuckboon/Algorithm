import java.util.*;

class Solution {
    static final int STUDENTS = 3;
    
    public int[] solution(int[] answers) {
        int questions = answers.length;
        int[][] pattern = { {1, 2, 3, 4, 5}
                           , {2, 1, 2, 3, 2, 4, 2, 5}
                           , {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
                          };
        
        int[] count = new int[STUDENTS + 1];
        count[0] = -1;
        
        for (int i = 1; i <= STUDENTS; i++) {
            for (int j = 1; j <= questions; j++) {
                // pattern[i-1]에서 인덱스 0부터 length-1까지 순회
                if (answers[j - 1] == pattern[i-1][(j-1) % pattern[i-1].length]) {
                    count[i] += 1;
                }
            }
        }
        
        int max = Arrays.stream(count).max().orElse(0);
                    
        return Arrays.stream(new int[] {1, 2, 3}).filter(i -> count[i] == max).toArray();
    }
}