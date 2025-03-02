import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int up = Integer.parseInt(st.nextToken());
            final int slip = Integer.parseInt(st.nextToken());
            final int goal = Integer.parseInt(st.nextToken());

            int count = 1 + (int) Math.ceil((double) (goal - up)/(up - slip));

            System.out.println(count);

        }
    }
}