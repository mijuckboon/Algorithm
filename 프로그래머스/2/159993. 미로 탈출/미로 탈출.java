import java.util.*;

class Solution {
    // LRUD
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final int len = dx.length;
    
    private static class Point {
        int nx;
        int ny;
        
        public Point(int nx, int ny) {
            this.nx = nx;
            this.ny = ny;
        }        
    }
    
    public int solution(String[] maps) {
        int rowCount = maps.length;
        int colCount = maps[0].length(); // String이므로 메서드
        
        char[][] map = new char[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            map[i] = maps[i].toCharArray();
        }
        /* 다른 방법 */
        // char[][] map = Arrays.stream(maps)
        //              .map(String::toCharArray)
        //              .toArray(char[][]::new);
        
        Point start = null;
        Point end = null;
        Point lever = null;
        
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                switch (map[i][j]) {
                    case 'S': start = new Point(j, i); break;
                    case 'E': end = new Point(j, i); break;
                    case 'L': lever = new Point(j, i); break;
                }
            }
        }
        
        // 시작 지점 -> 레버, 레버 -> 출구 까지의 최단 거리 각각 구하기
        int startToLever = bfs(start, lever, map);
        int leverToEnd = bfs(lever, end, map);
        
        if (startToLever == -1 || leverToEnd == -1) {
            return -1;
        }
        else {
            return startToLever + leverToEnd;
        }
    }
        
        private int bfs(Point start, Point end, char[][] map) {
            int rowCount = map.length;
            int colCount = map[0].length; 
            
            int[][] dist = new int[rowCount][colCount];
            Queue<Point> queue = new ArrayDeque<>();
            dist[start.ny][start.nx] = 1;
            queue.add(start);
            
            while (!queue.isEmpty()) {
                Point now = queue.poll();
                
                for (int i = 0; i < len; i++) {
                    int nextX = now.nx + dx[i];
                    int nextY = now.ny + dy[i];
                    
                    if (nextX < 0 || nextX >= colCount || nextY < 0 || nextY >= rowCount) {
                        continue;
                    }
                    
                    // 이미 방문한 경우 패스
                    if (dist[nextY][nextX] > 0) {
                        continue;
                    }
                    
                    // 벽
                    if (map[nextY][nextX] == 'X') {
                        continue;
                    }
                    
                    dist[nextY][nextX] = dist[now.ny][now.nx] + 1;
                    
                    queue.add(new Point(nextX, nextY));
                    
                    if (nextX == end.nx && nextY == end.ny) {
                        return dist[end.ny][end.nx] - 1;
                    }
                    
                    
                }
                
            }
            return -1;
        }
    }