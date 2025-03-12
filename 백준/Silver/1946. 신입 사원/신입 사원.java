import java.util.*;
import java.io.*;

public class Main {
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int numTests = Integer.parseInt(br.readLine());
            StringTokenizer st;

            for (int i = 0; i < numTests; i++) {
                int numApplies = Integer.parseInt(br.readLine());
                Integer[][] ranks = new Integer[numApplies][2];
                for (int j = 0; j < numApplies; j++) {
                    st = new StringTokenizer(br.readLine());
                    ranks[j][0] = Integer.parseInt(st.nextToken());
                    ranks[j][1] = Integer.parseInt(st.nextToken());
                }

                PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(rank -> rank[0]));
                for (int j = 0; j < numApplies; j++) {
                    pq.offer(ranks[j]);
                }

                int minInterviewRank = Integer.MAX_VALUE;
                int interviewRank;
                int count = 0;
                for (int j = 0; j < numApplies; j++) {
                    interviewRank = pq.poll()[1];
                    if (minInterviewRank > interviewRank) {
                        minInterviewRank = interviewRank;
                        count += 1;
                    }
                }
                sb.append(count).append(System.lineSeparator());
            }
            System.out.println(sb.toString().trim());
        }
    }
}