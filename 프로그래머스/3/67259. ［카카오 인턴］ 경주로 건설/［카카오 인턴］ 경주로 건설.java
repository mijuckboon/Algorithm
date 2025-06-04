import java.util.*;

class Solution {
    private static class Node {
        int x;
        int y;
        int direction; // 코너 처리가 필요하므로 방향 정보 관리
        int cost;
    
        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        } 
    }
    
    // DLUR
    private static final int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private static final int DIR_COUNT = dir.length;
    private static final int STRAIGHT_COST = 100;
    private static final int CORNER_COST = STRAIGHT_COST + 500;
    
    // 보드 범위 내인지 확인
    private static boolean isValid(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
    
    // 시작점 재방문 방지, 보드 바깥이나 벽인지 체크
    private static boolean isBlocked(int[][] board, int x, int y, int N) {
        return (x == 0 && y == 0) || !isValid(x, y, N) || board[x][y] == 1;
    }
    
    private static boolean isStraight(int direction, int prevDirection) {
        return (prevDirection - direction) % 2 == 0;
    }
    
    private static int computeCost(int direction, int prevDirection, int cost) {
     if (prevDirection == -1 || isStraight(direction, prevDirection)) {
         return cost + STRAIGHT_COST;
     }   
        return cost + CORNER_COST; // 코너일 때
    }
    
    // 아직 방하지 않았거나 새 비용이 더 작은 경우 (큐에 추가)
    private static boolean needsUpdate(int x, int y, int direction, int newCost, int[][][] visited) {
        return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
    }
    
    public int solution(int[][] board) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0));
        int N = board.length;
        int[][][] visited = new int[N][N][DIR_COUNT]; // 비용 0인 경우도 대비하려면 Integer.MAX_VALUE로 fill
        
        int minCost = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            for (int i = 0; i < DIR_COUNT; i++) {
                // new_x 대신 Java 컨벤션 맞게
                int newX = now.x + dir[i][0];
                int newY = now.y + dir[i][1];
                
                if (isBlocked(board, newX, newY, N)) {
                    continue;
                }
            
                int newCost = computeCost(i, now.direction, now.cost);
                
                if (newX == N - 1 && newY == N - 1) {
                    minCost = Math.min(minCost, newCost);
                }
                
                else if(needsUpdate(newX, newY, i, newCost, visited)) {
                    queue.add(new Node(newX, newY, i, newCost));
                    visited[newX][newY][i] = newCost;
                }
                
            }
            
            
        }
        
    
        return minCost;
    }
}