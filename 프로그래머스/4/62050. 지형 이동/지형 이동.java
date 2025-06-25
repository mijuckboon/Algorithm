import java.util.*;

class Solution {
    private static class Node {
        int row;
        int col;
        int cost;
        
        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    public int solution(int[][] land, int height) {
        int totalCost = 0;
        int n = land.length; // 정사각형
        
        // LRUD
        int[] moveRow = {0, 0, -1, 1};
        int[] moveCol = {-1, 1, 0, 0};
        boolean[][] isVisited = new boolean[n][n];
        
        // cost에 대한 오름차순 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        pq.add(new Node(0, 0, 0)); // 시작점 추가
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (isVisited[now.row][now.col]) { // 이미 방문한 곳이면 스킵
                continue;
            }
            
            isVisited[now.row][now.col] = true;
            totalCost += now.cost;
            
            for (int i = 0; i < moveRow.length; i++) {
                int newRow = now.row + moveRow[i];
                int newCol = now.col + moveCol[i];
                
                if (!isValid(newRow, newCol, n)) {
                    continue;
                }
                
                int tempCost = Math.abs(land[now.row][now.col] - land[newRow][newCol]);
                int newCost = tempCost > height ? tempCost : 0;
                pq.add(new Node(newRow, newCol, newCost));
            }
            
        }
        
        return totalCost;
    }
    
    private boolean isValid(int x, int y, int n) {
        return (x >= 0) && (x < n) && (y >= 0) && (y < n);
    }
}