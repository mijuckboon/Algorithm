import java.util.*;
class Solution {
    private static final String REMOVER = "Z";
    
    public int solution(String s) {
        String[] strs = s.split(" ");
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (String str: strs) {
            if (str.equals(REMOVER)) {
                deque.pop();
            }
            if (!str.equals(REMOVER)) {
                deque.push(Integer.parseInt(str));
            }
        }
        
        return deque.stream().mapToInt(x -> x).sum(); // default 0 되는 듯
    }
}