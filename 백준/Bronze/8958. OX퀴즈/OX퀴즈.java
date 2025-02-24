import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            String quiz = br.readLine();
            int sum = 0;
            int score = 0;
            for (int j = 0; j < quiz.length(); j++) {
                char ch = quiz.charAt(j);
                if (ch == 'O') {
                    score += 1;
                } else {
                    score = 0;
                }
                sum += score;
            }
            sb.append(sum);
            sb.append(System.lineSeparator());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}