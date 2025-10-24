import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothMap = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1]; // 여기선 수만 중요
            clothMap.put(type, clothMap.getOrDefault(type, 0) + 1);
        }
        
        return numberOfCases(clothMap);
    }
    
    private int numberOfCases(Map<String, Integer> clothMap) {
        int numberOfCases = 1;
        for (String type : clothMap.keySet()) {
            numberOfCases *= clothMap.get(type) + 1; // 후보 중 선택 혹은 입지 않음
        }
        
        return numberOfCases - 1; // 아무것도 입지 않는 경우 제외
    }
}