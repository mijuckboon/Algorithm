import java.util.*;

class Solution {
    static final int LEFT = -5;
    static final int RIGHT = 5;
    static final int UP = 5;
    static final int DOWN = -5;
    
    private boolean isValid(int x, int y) {
        return (x >= LEFT) && (x <= RIGHT) && (y >= DOWN) && (y <= UP);
    }
    
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            int movedX = x;
            int movedY = y;
            
            char dir = dirs.charAt(i);
            switch (dir) {
                case 'U' -> movedY += 1;
                case 'D' -> movedY -= 1;
                case 'L' -> movedX -= 1;
                case 'R' -> movedX += 1;
            }
            
            if (!isValid(movedX, movedY)) continue;
            
            visited.add(String.format("%d %d %d %d", x, y, movedX, movedY) );
            visited.add(String.format("%d %d %d %d", movedX, movedY, x, y) );
            
            // 버전 낮아서 지원 안되는 듯
            // visited.add("%d %d %d %d".formatted(x, y, movedX, movedY) );
            // visited.add("%d %d %d %d".formatted(movedX, movedY, x, y) );
            
            x = movedX;
            y = movedY;
            }
        
        return visited.size()/2;
    } 

    /* 방문한 점의 수와 선분의 길이는 다름!
     * 테스트 1
     * 입력값    〉"ULURRDLLU"
     * 기댓값    〉7
     * 실행 결과 〉실행한 결괏값 6이 기댓값 7과 다릅니다.*/
    
//     public int solution(String dirs) {
//         boolean[][] visited = new boolean[UP - DOWN + 1][RIGHT - LEFT + 1];
//         int x = - LEFT;
//         int y = - DOWN;
        
//         for (int i = 0; i < dirs.length(); i++) {
//             int movedX = x;
//             int movedY = y;
            
//             char dir = dirs.charAt(i);
//             switch (dir) {
//                 case 'U' -> movedY += 1;
//                 case 'D' -> movedY -= 1;
//                 case 'L' -> movedX -= 1;
//                 case 'R' -> movedX += 1;
//             }
            
//             if (movedX >= 0 && movedX <= RIGHT - LEFT + 1 && movedY >= 0 && movedY <= UP - DOWN + 1) {
//                 x = movedX;
//                 y = movedY;
//             }
            
//             visited[y][x] = true;
//         }
        
//         int count = 0;
//         for (int j = 0; j < UP - DOWN + 1; j++) {
//             for (int i = 0; i < RIGHT - LEFT + 1; i++) {
//                 if (visited[j][i] == true) count += 1;  
//             }
//         }
        
//         return count;
//     } 
}