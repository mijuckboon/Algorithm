class Solution {
    private static final int DIVBY = 1234567;
    
    public int solution(int n) {
        int[] fibonacci = new int[100001];
        fibonacci[1] = 1;
        fibonacci[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % DIVBY;
        }
        
        return fibonacci[n];
    }
}