import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> firstDeck = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> secondDeck = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> words = new LinkedList<>(Arrays.asList(goal));
        
        while (!words.isEmpty()) {
            String word = words.peek();
            String word1 = firstDeck.peek();
            String word2 = secondDeck.peek();
            
            if (!word.equals(word1) && !word.equals(word2)) break;
            
            if (word.equals(word1)) {
                words.poll();
                firstDeck.poll();
                continue;
            }
            
            if (word.equals(word2)) {
                words.poll();
                secondDeck.poll();
            }
        }
        
        return words.isEmpty()? "Yes" : "No";

        
        
        // goal을 완성해도 덱이 비지 않을 수 있음 (goal.length < cards1.length + cards2.length)
//         for (int i = 0; i < goal.length; i++) {
//             if (goal[i].equals(firstDeck.peek())) {
//                 firstDeck.poll();
//                 continue;
//             }
//             if (goal[i].equals(secondDeck.peek())) {
//                 secondDeck.poll();
//             }
//         }
        
//         return (firstDeck.isEmpty() && secondDeck.isEmpty())? "Yes" : "No";
    }
}