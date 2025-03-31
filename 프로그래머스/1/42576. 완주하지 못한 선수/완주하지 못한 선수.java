import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completed = new HashMap<>();
        for (String name : completion) {
            completed.put(name, completed.getOrDefault(name, 0) + 1);
        }
        
        for (String name : participant) {
            if (completed.containsKey(name)) {
                completed.put(name, completed.get(name) - 1);
            }
            if (!completed.containsKey(name) || completed.get(name) < 0) {
                return name;
            }
        }
        return null;
    }
}