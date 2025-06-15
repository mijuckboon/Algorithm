import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> results = new ArrayList<>();
        
        for (int[] command : commands) {
            int[] cutted = cutted(array, command);
            Arrays.sort(cutted);
            results.add(cutted[command[2] - 1]);
        }

        return results.stream().mapToInt(x -> x).toArray();
    }
    
    private int[] cutted(int[] array, int[] command) {
        int len = command[1] - command[0] + 1;
        int[] cutted = new int[len];
        
        for (int i = 0; i < len; i++) {
            cutted[i] = array[i + command[0] - 1];
        }
        
        return cutted;
    }
    
}