import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> lines = new ArrayList<>();
        // Stack<Integer>[] lines = new Stack<Integer>[board[0].length]; // generic array creation
        for (int j = 0; j < board[0].length; j++) {
            lines.add(new Stack<Integer>());
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    lines.get(j).push(board[i][j]);
                } else {
                    break;
                }
            }
        }
        
        Stack<Integer> stack = new Stack<>();        
        int count = 0;
        for (int k = 0; k < moves.length; k++) {
            int move = moves[k];
            Stack<Integer> targetLine = lines.get(move - 1); // 1번 스택은 lines에서 0번 인덱스
            if (targetLine.isEmpty()) {continue;} 
            int doll = targetLine.pop();
            if (stack.isEmpty() || stack.peek() != doll) {
                stack.push(doll);
            } else {
                stack.pop();
                count += 2; // 한 번에 2개씩 사라짐
            }   
        }
        
        return count;
    }
}