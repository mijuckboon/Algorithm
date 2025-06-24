import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int numCases = 0;
        
        //토핑, 개수
        Map<Integer, Integer> rightToppings = new HashMap<>();
        for (int top : topping) {
            rightToppings.put(top, rightToppings.getOrDefault(top, 0) + 1);
        }
        
        Set<Integer> leftToppings = new HashSet<>();
        
        for (int top : topping) {
            // 한 칸씩 이동 (왼쪽 토핑 증가, 오른쪽 토핑 감소)
            leftToppings.add(top);
            rightToppings.put(top, rightToppings.getOrDefault(top, 0) - 1);
            
            if (rightToppings.getOrDefault(top, 0) == 0) {
                rightToppings.remove(top);
            }
            
            if (leftToppings.size() == rightToppings.keySet().size()) {
                numCases += 1;
            }
            
        }
        return numCases;
    }
}