import java.io.*;
import java.util.*;

public class Main {
    static final int numColor = 3;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int numHouse = Integer.parseInt(br.readLine());
            int[][] rgb = new int[numHouse][numColor];

            StringTokenizer st;
            for (int i = 0; i < numHouse; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < numColor; j++) {
                    rgb[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[numHouse][numColor];
            for (int i = 0; i < numHouse; i++) {
                for (int j = 0; j < numColor; j++) {
                    dp[i][j] = rgb[i][j];
                    if (i >= 1) {
                        dp[i][j] += Math.min(dp[i-1][(j+1)%numColor], dp[i-1][(j+2)%numColor]);
                    }
                }
            }
            System.out.println(Arrays.stream(dp[numHouse-1]).min().orElse(0));
        }

    }

}