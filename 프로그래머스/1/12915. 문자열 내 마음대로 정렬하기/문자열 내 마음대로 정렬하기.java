import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> sorted = new ArrayList<>(Arrays.asList(strings));
        sorted.sort((s1, s2) -> {
            if (s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            }
            return s1.charAt(n) - s2.charAt(n);
            });
        
        // sorted.sort(
        //     Comparator.comparing((String s) -> s.charAt(n))  // n번째 문자 기준 정렬
        //               .thenComparing(Comparator.naturalOrder()) // 같으면 전체 문자열 사전순
        // );
        
        return sorted.toArray(new String[0]);
    }
}