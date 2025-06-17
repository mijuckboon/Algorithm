import java.util.*;
import java.util.stream.Collectors;
    
class Solution {
    public String solution(int[] numbers) {
        // Arrays.asList(numbers) -> 객체 배열이어야 가능! (고정 길이 리스트로 변환)
        
        // List<String> numbersAsString = new ArrayList<>();
        // for (int number : numbers) {
        //     numbersAsString.add(Integer.toString(number));
        // }
        
         /* 두 번째 import 문이 반드시 필요! */
        List<String> numbersAsString = Arrays.stream(numbers)
            .boxed()
            .map(n -> Integer.toString(n))
            .collect(Collectors.toList());
        
        numbersAsString.sort((o1, o2) -> {
            int first = Integer.parseInt(o1 + o2);
            int second = Integer.parseInt(o2 + o1);
            return Integer.compare(second, first);
        }
        );
        
        String maxNumber = String.join("", numbersAsString);
        
        // maxNumber = numbersAsString.stream()
        //     .reduce((x, y) -> x + y)
        //     .orElseGet(null);
        
        // maxNumber = numbersAsString.stream().collect(Collectors.joining());
        
        /* 000 -> 0 처리 */
        return maxNumber.charAt(0) == '0'? "0" : maxNumber;
        // return maxNumber.startsWith("0") ? "0" : maxNumber;
    }
}