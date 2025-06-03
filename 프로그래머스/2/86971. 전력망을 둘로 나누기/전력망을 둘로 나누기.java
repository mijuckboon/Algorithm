import java.util.*;

class Solution {
    private static int minDiff;
    
    public int solution(int n, int[][] wires) {
        minDiff = n; // 실제 최대는 n - 1 - 1 = n - 2 -> 충분히 큰 값
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            // 양방향
            adjList.get(wire[0]).add(wire[1]);
            adjList.get(wire[1]).add(wire[0]);
        }
        
        boolean[] isVisited = new boolean[n + 1];
        
        dfs(1, isVisited, adjList, n);
        
        return minDiff;
    }
    
    private int dfs(int now, boolean[] isVisited, List<List<Integer>> adjList, int n) {
        isVisited[now] = true;
        int nodeCount = 1; // now 반영
        
        // 연결된 전선 확인
        for (int next: adjList.get(now)) {
            if (!isVisited[next]) {
                int subTreeNodeCount = dfs(next, isVisited, adjList, n); // next를 루트로 하는 서브트리
                minDiff = Math.min(minDiff, Math.abs(n - 2 * subTreeNodeCount));
                nodeCount += subTreeNodeCount;
            }
        }
        
        return nodeCount;
    }
}