class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] isVisited = new boolean[n]; // 방문 배열
        
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i, isVisited, computers);
                count += 1;
            }
        }
        
        return count;
    }
    
    private void dfs(int now, boolean[] isVisited, int[][] computers) {
        isVisited[now] = true; // 방문 처리
        for (int i = 0; i < computers[now].length; i++) {
            if (computers[now][i] == 1 &&!isVisited[i]) {
                dfs(i, isVisited, computers);
            }
        }
    }
}