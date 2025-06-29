class Solution {
    public boolean solution(String s) {
        char[] chars = s.toCharArray();
        
        for (char ch : chars) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        return true;
    }
}