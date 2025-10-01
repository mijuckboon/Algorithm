class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0;
        int currentAPT = 1; // 탐색 위치 (1부터 시작)
        int stationIdx = 0;
        
        while (currentAPT <= n) {
            // 기지국 범위 내이면 기지국 범위를 최초로 벗어나는 위치로 이동
            if (isInRange(stationIdx, stations, currentAPT, w)) {
                currentAPT = stations[stationIdx] + w + 1;
                stationIdx++;
            }
            // 범위 바깥이면 current + w 위치에 하나 설치 후 바깥으로 이동
            else {
                currentAPT += 2 * w + 1;
                count += 1;
            }
        }
        return count;
    }
    
    private boolean isInRange(int stationIdx, int[] stations, int currentAPT, int w) {
        return stationIdx < stations.length && currentAPT >= stations[stationIdx] - w;
    }
}