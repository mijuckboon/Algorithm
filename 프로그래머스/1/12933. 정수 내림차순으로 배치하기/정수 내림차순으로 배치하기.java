class Solution {
    public long solution(long n) {
        String input = Long.toString(n);
        int[] count = new int[10];
        
        for (int i = 0; i < input.length(); i++) {
            int digit = Integer.parseInt(Character.toString(input.charAt(i)));
            // int digit = Integer.parseInt(input.charAt(i) + "");
            count[digit] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            sb.append(Integer.toString(i).repeat(count[i])); 
        }
        
        return Long.parseLong(sb.toString());
    }
}