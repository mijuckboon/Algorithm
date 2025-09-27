class Solution {
    public int solution(int[] money) {
        int len = money.length;
        int[] maxWithFirstHouse = new int[len];
        int[] maxWithoutFirstHouse = new int[len];
        
        maxWithFirstHouse[0] = money[0];
        maxWithFirstHouse[1] = money[0];
        
        maxWithoutFirstHouse[1] = money[1];
        
        for (int i = 2; i < len; i++) {
            maxWithoutFirstHouse[i] = Math.max(maxWithoutFirstHouse[i - 2] + money[i], maxWithoutFirstHouse[i - 1]);
            
            if (i == len - 1) {
                break;
            }
            maxWithFirstHouse[i] = Math.max(maxWithFirstHouse[i - 2] + money[i], maxWithFirstHouse[i - 1]);
        }
        
        // 첫 번째 집을 털었으면 마지막 (index len - 1) 집을 털 수 없음
        int globalMax = Math.max(maxWithFirstHouse[len - 2], maxWithoutFirstHouse[len - 1]);
        return globalMax;
    }
}