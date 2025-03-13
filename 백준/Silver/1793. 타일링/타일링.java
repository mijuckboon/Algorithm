import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    static BigInteger[] dp = new BigInteger[251]; // long 범위를 넘어서므로 BigInteger 사용
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 초깃값 제공
            dp[0] = BigInteger.ONE;
            dp[1] = BigInteger.ONE;
            dp[2] = new BigInteger("3");
           
            StringBuilder sb = new StringBuilder();
            
            while (true) {
                String input = br.readLine();
                if (input == null) {
                    break;
                }
                int num = Integer.parseInt(input);
                sb.append(fillDP(num)).append(System.lineSeparator());
            }
            System.out.println(sb.toString().trim());
        }
    }
    private static BigInteger fillDP(int num) {
        if (dp[num] != null) {
            return dp[num];
        }
        for (int i = 3; i <= num; i++) {
            if (dp[i] != null) { // 비어있으면 값을 입력 (memoization)
                continue;
            }
            // 가로 길이 1인 직사각형(i-1), 가로 길이 2인 직사각형(i-2), 정사각형(i-2)
            dp[i] = dp[i - 1].add(dp[i-2].multiply(BigInteger.TWO));
        }
        return dp[num];
    }
}