class Solution {
    private int cnt;
    
    public int solution(int k, int[][] dungeons) {
        cnt = 0;
        boolean[] isVisited = new boolean[dungeons.length];
        
        backtrack(k, dungeons, isVisited, 0);
        return cnt;
    }
    
    private void backtrack(int k, int[][] dungeons, boolean[] isVisited, int currentCnt) {
        for (int i = 0; i < dungeons.length; i++) {
            // 방문하지 않았고 최소 피로도보다 크거나 같으면
            if (!isVisited[i] && k >= dungeons[i][0]) {
                isVisited[i] = true;
                
                // 소모 필요도 차감, count += 1                
                backtrack(k - dungeons[i][1], dungeons, isVisited, currentCnt + 1);
                cnt = Math.max(cnt, currentCnt + 1);
                
                // 재귀를 빠져나갈 때 미방문 처리
                isVisited[i] = false;
            }
            
        }
    }
}

/* 순수 함수 스타일 */
// class Solution {
//     public int solution(int k, int[][] dungeons) {
//         boolean[] isVisited = new boolean[dungeons.length];
//         return backtrack(k, dungeons, isVisited);
//     }

//     private int backtrack(int k, int[][] dungeons, boolean[] isVisited) {
//         int maxCount = 0;

//         for (int i = 0; i < dungeons.length; i++) {
//             if (!isVisited[i] && k >= dungeons[i][0]) {
//                 isVisited[i] = true;
//                 // 현재 던전 클리어하고 남은 피로도로 다음 탐색 시도
//                 int count = 1 + backtrack(k - dungeons[i][1], dungeons, isVisited);
//                 maxCount = Math.max(maxCount, count);
//                 isVisited[i] = false;  // 상태 복구
//             }
//         }

//         return maxCount;
//     }
// }
