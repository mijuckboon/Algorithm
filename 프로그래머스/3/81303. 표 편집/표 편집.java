import java.util.*;

class Solution {
    static int[] up;
    static int[] down;
    
    static Stack<Integer> deleted = new Stack<>();
    
    public String solution(int n, int k, String[] cmd) {
        /* idea
         * 1. soft delete
         * 2. 유사-LinkedList (배열을 정의하고 인덱스 만으로 연산) */
        up = new int[n + 2]; // 2: edge 근방의 가상 공간
        down = new int[n + 2];
        
        for (int i = 0; i <= n + 1; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        int current = k + 1; // 가상 공간 생성으로 한 칸 뒤로 밀림

        for (String command : cmd) {
            StringTokenizer st = new StringTokenizer(command);
            char type = st.nextToken().charAt(0);
            
            switch (type) {// 각각의 명령어 수행
                case 'U' -> {
                    int move = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < move; i++) {
                        current = up[current];
                    }
                }
                case 'D' -> {
                    int move = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < move; i++) {
                        current = down[current];
                    }
                }
                case 'C' -> {
                    deleted.push(current);
                    up[down[current]] = up[current];
                    down[up[current]] = down[current];
                    current = (down[current] > n ? up[current] : down[current]);
                }
                case 'Z' ->  {
                    int recover = deleted.pop();
                    down[up[recover]] = recover;
                    up[down[recover]] = recover;
                }
            }
            
        }
        
        // StringBuilder sb = new StringBuilder();
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for (int i : deleted) {
            answer[i - 1] = 'X';
        }
        
   
//        for (int i = 1; i <= n; i++) { // 로직 잘못됨: 폐기
//             if (down[i] - up[i] == 2) {
//                 sb.append("O");
//             } else {
//                 sb.append("X");
//             }

//         }       
        
        return new String(answer);
        // return sb.toString();
    }
}