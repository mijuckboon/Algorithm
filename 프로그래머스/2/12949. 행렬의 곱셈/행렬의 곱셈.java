class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // arr에 대해 행의 개수: arr.length, 열의 개수: arr[0].length
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr2[0].length; k++ ){
                for (int j = 0; j < arr1[0].length; j++) {
                answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        
        return answer;
    }
}