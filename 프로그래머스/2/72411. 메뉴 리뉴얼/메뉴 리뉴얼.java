import java.util.*;

class Solution {
    private static final int REQUIRED_ORDER = 2;
    private static Map<String, Integer> courseMap;
    private static Set<Integer> lengthSet;
    
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        lengthSet = new HashSet<>();
        
        for (int menuNum : course) {
            lengthSet.add(menuNum);
        }
        
        // 오름차순 정렬
        for (String order : orders) {
            char[] orderedMenus = order.toCharArray();
            Arrays.sort(orderedMenus);
            combinations(0, orderedMenus, "");
        }
        
        List<String> composedCourses = new ArrayList<>();
        
        for (int menuNum : course) {
            int maxCount = 0;
            
            for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
                    if (hasSameLength(entry, menuNum)) {
                        maxCount = Math.max(maxCount, entry.getValue());
                    }
                }

                if (maxCount >= REQUIRED_ORDER) {
                    for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
                        if (isComposeCourse(entry, menuNum, maxCount)) {
                            composedCourses.add(entry.getKey());
                        }
                    }
                }
            }
        
        Collections.sort(composedCourses);
        return composedCourses.toArray(new String[0]);
    }
    
    private static void combinations(int idx, char[] order, String result) {
        if (hasRequiredMenuCount(result)) {
           courseMap.put(result, courseMap.getOrDefault(result, 0) + 1);
        }
        
        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }
    
    private static boolean hasRequiredMenuCount(String result) {
        return lengthSet.contains(result.length());
    }
    
    private static boolean hasSameLength(Map.Entry<String, Integer> entry, int targetLength) {
        return entry.getKey().length() == targetLength;
    }
    
    private static boolean isComposeCourse(Map.Entry<String, Integer> entry, int targetLength, int maxCount) {
        return hasSameLength(entry, targetLength) && entry.getValue() == maxCount;
    }
}