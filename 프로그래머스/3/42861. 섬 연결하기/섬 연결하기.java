import java.util.*;

class Solution {
    static int[] parent;
    
    private int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]); // 경로 압축
        return parent[x];
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[Math.max(a, b)] = Math.min(a, b);
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(x -> x[2])); // 비용 기준 오름차순 정렬
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int totalCost = 0;
        int count = 1; // 출발점에서 시작하여 연결된 node 수 count
        
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            if (find(from) != find(to)) { // 연결되지 않은 경우
                union(from, to); // 연결
                totalCost += cost;
                count += 1;
            }
            
            if (count == n) {
                break;
            }
        }
        return totalCost;
    }
}