class Solution {
    public int[] solution(String s) {
        int count = 0;
        int deletedZeros = 0;
        
        String target = new String(s);
        
        while (!target.equals("1")) {
            count += 1;
            for (char ch : target.toCharArray()) {
                if (ch == '0') {
                    deletedZeros += 1;
                }
            }
            // deletedZeros += target.toCharArray().stream().filter(char -> char == '0').count();
            target = target.replace("0", ""); // target.replace("0", ""); -> 무한 루프 도는 듯
            int len = target.length();
            target = getBinaryString(len);
        }
        
        return new int[] {count, deletedZeros};
    }
    
    String getBinaryString(int n) {
        String str = "";
        while (n > 0) {
            str = Integer.toString(n % 2) + str;
            n /= 2;
        }
        
        return str;
    }
}