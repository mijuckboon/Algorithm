import java.util.*;

class Solution {
    // LRUD -> 배열이므로 y x 순
    // private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final int[][] moves = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    
    public int solution(int[][] maps) {
        int hor = maps[0].length; // 열의 개수 (가로 길이)
        int ver = maps.length;
        
        // 최단 거리 저장
        int[][] dist = new int[ver][hor];
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[] {0, 0});
        dist[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int[] move : moves) {
                int x = now[1] + move[1];
                int y = now[0] + move[0];
                
                // 맵 바깥
                if (x < 0 || y < 0 || x >= hor || y >= ver) {
                    continue;
                }
                
                // 벽
                if (maps[y][x] == 0) {
                    continue;
                }
                
                if (dist[y][x] == 0) {
                    queue.add(new int[] {y, x});
                    dist[y][x] = dist[now[0]][now[1]] + 1;
                }
            }    
        }
        
        int minDist = dist[ver - 1][hor - 1];
        if (minDist == 0) {
            return -1;
        }
        return minDist;
    }
}