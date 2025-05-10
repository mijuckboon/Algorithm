import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> spokenWords = new HashSet<>();
        int len = words.length;
        
        for (int i = 0; i < len; i++) {
            int person = (i % n) + 1;
            int round = i / n + 1;
            
            String word = words[i];
            if (i >= 1) {
                String prevWord = words[i - 1];
                if (word.charAt(0) != prevWord.charAt(prevWord.length() - 1)) {
                    return new int[] {person, round};
                }
            }
            
            if (spokenWords.contains(word)) {
            return new int[] {person, round};
            }
            spokenWords.add(word);
            
        }
        return new int[] {0, 0};
    }
}