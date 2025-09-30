import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        int boatCount = 0;
        while (left <= right) {
            // 이 부분 뒤로 가면 테스트 2 실패 (50 + 50을 계산하는 듯)
            if (people[left] + people[right] <= limit) {
                left += 1;
            }
            
            right -= 1;
            boatCount += 1;
        }
        
        return boatCount;
    }
}