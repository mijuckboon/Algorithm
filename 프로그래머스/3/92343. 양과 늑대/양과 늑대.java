import java.util.*;

class Solution {
    // edges가 주어졌으므로 인접 리스트 이용
    private List<List<Integer>> adjList;
    private int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        int len = info.length;
        adjList = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            adjList.add(new ArrayList<>()); // 노드 초기화
        }
        
        // 트리 구조에 맞게 자식 노드 연결
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]); // 부모 -> 자식 연결
        }

        // DFS 시작 (전체 경로 탐색)
        dfs(new State(0, 0, 0, new ArrayList<>(List.of(0))), info);
        return maxSheep;
    }

    private void dfs(State state, int[] info) {
        // 양과 늑대 카운트 업데이트
        if (info[state.node] == 0) {
            state.sheep++;
        } else {
            state.wolf++;
        }

        // 양이 잡아먹히는 상황이 되면 경로 탐색 종료
        if (state.wolf >= state.sheep) return;

        // 최대 양의 수 기록
        maxSheep = Math.max(maxSheep, state.sheep);

        // 다음 노드 탐색을 위한 새로운 상태 생성
        List<Integer> newNextNodes = new ArrayList<>(state.nextNodes);
        newNextNodes.remove(Integer.valueOf(state.node));  // 현재 노드는 제거
        newNextNodes.addAll(adjList.get(state.node));      // 자식 노드들 추가

        // 자식 노드들에 대해 재귀적으로 DFS 호출 -> 백트래킹
        for (int next : newNextNodes) {
            dfs(new State(next, state.sheep, state.wolf, newNextNodes), info);
        }
    }

    // 상태 관리 클래스
    private static class State {
        int node;       // 현재 노드
        int sheep;      // 양의 수
        int wolf;       // 늑대의 수
        List<Integer> nextNodes;  // 방문할 노드들

        // 생성자
        public State(int node, int sheep, int wolf, List<Integer> nextNodes) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.nextNodes = nextNodes;
        }
    }
}
