import java.util.*;

class Solution {
    static List<Character> openPars = Arrays.asList('(', '{', '[');
    static List<Character> closePars = Arrays.asList(')', '}', ']');
    
    private char getDualPar(char par) {
        return openPars.get(closePars.indexOf(par));
    }
    
    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
            
        for (int i = 0; i < s.length(); i++){
            char par = s.charAt(i);
            if (openPars.contains(par)) {
                stack.push(par);
            } else {
                if (stack.isEmpty() || !stack.peek().equals(getDualPar(par))) {
                    return false;
                } 
                stack.pop();         
                }
                
            }  
         return stack.isEmpty();
            
    }
        
    public int solution(String s) {        
        int len = s.length();
        int count = 0;
              
        for (int i = 0; i < len; i++) {
            s = s.substring(1, len) + s.substring(0, 1);
            if (isCorrect(s)) {
                count += 1;
            }
        }
        
        return count;
    }
}