import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        int dictIndex = 1;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            dictionary.put(Character.toString(ch), dictIndex);
            dictIndex += 1;
        }
        
        int pos = 0;
        int msgLength = msg.length();
        List<Integer> indices = new ArrayList<>();
        
        while (pos < msgLength) {
            char currentChar = msg.charAt(pos);
            String currentWord = Character.toString(currentChar);
            int nextPos = pos + 1;
            
            String targetWord = msg.substring(pos, nextPos);
            while (nextPos <= msgLength && dictionary.containsKey(targetWord)) {
                currentWord = targetWord;
                nextPos += 1;
                
                if (nextPos <= msgLength) {
                    targetWord = msg.substring(pos, nextPos);
                }
            }
            
            indices.add(dictionary.get(currentWord));
            
            if (nextPos <= msgLength) {
                dictionary.put(targetWord, dictIndex);
                dictIndex += 1;
            }

            pos += currentWord.length();
        }
        
        return indices.stream().mapToInt(x -> x).toArray();
    }
}