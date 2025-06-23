import java.util.*;

public class Solution {
    public int solution(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) { // n == 1이면 여기 (분리할 필요 X)
                n -= 1;
                count += 1;
            }
            if (n % 2 == 0) {
                n /= 2;
            }
        }
        return count;
    }
}