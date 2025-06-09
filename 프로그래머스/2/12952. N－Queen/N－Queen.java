class Solution {
    public int solution(int n) {
        boolean[] hasQueenInCol = new boolean[n];
        boolean[] hasQueenInUpwardDiag = new boolean[2 * n]; // 우상향
        boolean[] hasQueenInDownwardDiag = new boolean[2 * n]; // 우하향
        
        return countCases(0, n, hasQueenInCol, hasQueenInUpwardDiag, hasQueenInDownwardDiag);
    }
    
    private int countCases(
        int row, int n, boolean[] hasQueenInCol,
        boolean[] hasQueenInUpwardDiag, boolean[] hasQueenInDownwardDiag
    ) {
        int count = 0;
        if (row == n) {// 모든 행에 대해 채워진 경우
            return 1;
            // count += 1; // 경우의 수 카운터에 1 추가
        }
        // else { <- 하단 풀이 보고 수정
            for (int col = 0; col < n; col++) {
                // 해당 열 또는 대각선에 이미 퀸이 있는 경우
                if (hasQueenInCol[col] || hasQueenInUpwardDiag[col + row] || hasQueenInDownwardDiag[n - row + col]) {
                    continue;
                }
                
                // 퀸 배치
                hasQueenInCol[col] = true;
                hasQueenInUpwardDiag[col + row] = true;
                hasQueenInDownwardDiag[n - row + col] = true;
                
                count += countCases(row + 1, n, hasQueenInCol, hasQueenInUpwardDiag, hasQueenInDownwardDiag);
                
                // 퀸 제거
                hasQueenInCol[col] = false;
                hasQueenInUpwardDiag[col + row] = false;
                hasQueenInDownwardDiag[n - row + col] = false;
                
                
            }
            
        // }
        return count;
        
        
    }
}

/* Min Ho Pak님 깔끔한 풀이 */
// public int nQueen(int n) {
//         int result = 0;
//         int[] cols = new int[n];
//         result = backTrack(0, cols, n);

//         return result;
//     }

//     public int backTrack(int level, int[] cols, int n) {
//         int sum = 0;
//         if (level == n) {
//             return 1;
//         } else {
//             for (int i = 0; i < n; i++) {
//                 cols[level] = i;
//                 if (possible(level, cols)) {
//                     sum += backTrack(level + 1, cols, n);
//                 }
//             }
//         }
//         return sum;
//     }


//     public boolean possible(int level, int[] cols) {
//         for (int i = 0; i < level; i++) {
//             if (cols[i] == cols[level] || Math.abs(level - i) == Math.abs(cols[i] - cols[level])) {
//                 return false;
//             }
//         }
//         return true;
//     }