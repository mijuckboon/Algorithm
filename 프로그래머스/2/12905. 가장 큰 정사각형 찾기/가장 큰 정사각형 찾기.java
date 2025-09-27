import java.util.*;

class Solution
{
    public int solution(int[][] board)
    {
        int rowCount = board.length;
        int colCount = board[0].length;
        
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (board[i][j] == 1) {
                    int up = board[i - 1][j];
                    int diag = board[i - 1][j - 1];
                    int left = board[i][j - 1];
                    
                    // 스트림 썼더니 시간 초과
                    board[i][j] = Math.min(Math.min(up, diag), left) + 1;                    
                }
            }
        }
        
        int side = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                side = Math.max(board[i][j], side);
            }
        }
        return side * side;
    }
}