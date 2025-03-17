import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> rates = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            int j = i; // lambda 식 쓰기 위한 유사-final 변수
            double arrived = (double) Arrays.stream(stages).filter(num -> num >= j).count();
            if (arrived == 0) { // 도달한 유저가 없으면 0
                rates.put(i, arrived);
            } else {
                rates.put(i, (double) Arrays.stream(stages).filter(num -> num == j).count() / arrived);
            }
        }
                    
        return rates.keySet().stream()
            .sorted(Comparator.comparingDouble(i -> -rates.get(i)))
            .mapToInt(x -> x)
            .toArray();
    }
}