import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int len = prices.length;
        int[] counts = new int[len];
        
        // int currentPrice = 0; 매번 peek 하면서 새로 확인해야함. 불필요
        for (int i = 0; i < len; i++) { 
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                // 가격이 떨어진 경우 기존에 push한 index를 pop
                int j = stack.pop();
                counts[j] = i - j;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int j = stack.pop();
            counts[j] = len - j - 1;
        }
        
        return counts;
    }
}