import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        
        // int[][] maxSum = new int[height][height];
        // maxSum[0][0] = triangle[0][0];
        
        int[][] maxSum = new int[height + 1][height + 1];
        
        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= row; col++) {
                maxSum[row][col] = Math.max(maxSum[row - 1][col - 1], maxSum[row - 1][col])
                    + triangle[row - 1][col - 1];
            }
        }
        return Arrays.stream(maxSum[height]).max().orElse(0);
    }
}