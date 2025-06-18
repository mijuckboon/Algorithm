import java.util.*; 

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        boolean hasPrefix = false; //cf. 접미사: suffix
        for (int i = 0; i < phone_book.length - 1; i++) {
            String prev = phone_book[i];
            String now = phone_book[i + 1];
            
            if (now.startsWith(prev)) {
                hasPrefix = true;
            }
        }        
        
        return !hasPrefix;
    }
}