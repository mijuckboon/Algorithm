class Solution {
    private static final int DIVBY = 1_000_000_007;
    public int solution(int n) {
        int[] numCases = new int[60_001];
        numCases[1] = 1;
        numCases[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            // 세로 + 가로 
            numCases[i] = (numCases[i - 1] + numCases[i - 2]) % DIVBY;
        }
        
        return numCases[n];
    }
}