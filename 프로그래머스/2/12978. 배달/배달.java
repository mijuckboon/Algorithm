import java.util.*;

class Solution {
    /* 가중치가 있으므로 BFS X, 다익스트라 등 사용 */
    
    // 시작점이 항상 1이므로 Node 클래스에 시작점은 불필요
    private static class Node {
        int end;
        int time;
        
        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        // 인접 리스트 초기화
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
        // for (int i = 1; i <= N; i++) {
        //     adjList.get(i - 1) = new ArrayList<>();
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge: road) {
            // 양방향 통행
            adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Node(edge[0], edge[2]));
        }
        
        int[] times = new int[N + 1];
        Arrays.fill(times, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.time));
        pq.add(new Node(1, 0));
        times[1] = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            // 이미 최단 시간으로 방문했으면 패스
            if (times[now.end] < now.time) {
                continue;
            }
            
            
            for (Node next: adjList.get(now.end)) {
                if (times[next.end] > now.time + next.time) {
                    times[next.end] = now.time + next.time;
                    pq.add(new Node(next.end, times[next.end]));
                }
            }
        }

        return (int) Arrays.stream(times).filter(x -> x <= K).count();
    }
}