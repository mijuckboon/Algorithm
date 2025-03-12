import java.util.*;
import java.io.*;

public class Main { // 확인용 GPT 코드
    static final StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int numTests = Integer.parseInt(br.readLine());

            for (int i = 0; i < numTests; i++) {
                int numApplies = Integer.parseInt(br.readLine());
                int[] interviewRanks = new int[numApplies + 1]; // 서류 심사 등수 -> 면접 등수를 저장하는 배열
                
                for (int j = 0; j < numApplies; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int docRank = Integer.parseInt(st.nextToken());
                    int interviewRank = Integer.parseInt(st.nextToken());
                    interviewRanks[docRank] = interviewRank; // 정렬 없이 직접 저장
                }

                int minInterviewRank = Integer.MAX_VALUE;
                int count = 0;

                for (int j = 1; j <= numApplies; j++) { // 1등부터 차례대로 확인
                    if (interviewRanks[j] < minInterviewRank) {
                        minInterviewRank = interviewRanks[j];
                        count++;
                    }
                }

                sb.append(count).append("\n");
            }
        }
        System.out.print(sb);
    }
}