import java.util.*;

class Solution {
    static int[] parent;
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
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

        int total = 0;
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            if (find(from) != find(to)) {
                union(from, to);
                total += cost;
            }
        }
        return total;
    }
}