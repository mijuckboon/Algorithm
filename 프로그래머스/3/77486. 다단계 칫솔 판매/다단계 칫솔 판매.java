import java.util.*;

class Solution {
    private static final int GAIN_UNIT = 100;
    private static final int RATE = 10;
        
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        /* 1. 판매원, 추천인 쌍을 저장 */
        Map<String, String> invitorMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            invitorMap.put(enroll[i], referral[i]);
        }
        
        /* 2. 판매원, 판매액 쌍 저장 */
        Map<String, Integer> earnedMap = new HashMap<>();
        
        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int earned = amount[i] * GAIN_UNIT;
            
            while (!sellerName.equals("-")) {            
                int distribute = earned * RATE / 100;
                
                earnedMap.put(sellerName, earnedMap.getOrDefault(sellerName, 0) + earned - distribute);
                
                if (distribute == 0) break;
                
                earned = distribute;
                sellerName = invitorMap.get(sellerName);
            }
            
            
        }
        
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = earnedMap.getOrDefault(enroll[i],0);
        }
        
        return answer;
    }
}
// 해시맵: 셀프 조인, 추적: 계층형 질의