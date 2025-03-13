import java.io.*;
import java.util.*;

public class Main {
    static int size;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            size = Integer.parseInt(br.readLine());
            int[][] board = new int[size][size];
            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            long[][] dp = new long[size][size];
            dp[0][0] = 1;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (dp[i][j] == 0 || board[i][j] == 0) {
                        continue;
                    }
                    int jump = board[i][j];
                    if (isValidIndex(i + jump, j)) {
                        dp[i + jump][j] += dp[i][j];
                    }
                    if (isValidIndex(i, j + jump)) {
                        dp[i][j + jump] += dp[i][j];
                    }

                }
            }

            System.out.println(dp[size - 1][size - 1]);
        }
    }

    private static boolean isValidIndex(int i, int j) {
        return (i >= 0 && i < size && j >= 0 && j < size);
    }

}