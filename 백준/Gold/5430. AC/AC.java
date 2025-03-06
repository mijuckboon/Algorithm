import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numTests = Integer.parseInt(br.readLine());
            for (int i = 0; i < numTests; i++) {
                String command = br.readLine();
                br.readLine(); // ignore
                String str = br.readLine()
                    .replace("[", "").replace("]", "");
                int[] array;
                if (!str.equals("")) {
                    array = Arrays.stream(str.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
                } else {
                    array = new int[0];
                }
                
                System.out.println(solution(command, array));
            }
        }
        
    }

    public static String solution(String command, int[] array) {
        Deque<Integer> numbers = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder("[");

        for (int number : array) {
            numbers.addLast(number);
        }
        boolean isReversed = false;

        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            if (ch == 'R') {
                isReversed = !isReversed;
            }
            if (ch == 'D') {
                if (numbers.isEmpty()) {
                    return "error";
                }
                if (isReversed) {
                    numbers.removeLast();
                } else {
                    numbers.removeFirst();
                }

            }
        }

        while (!numbers.isEmpty()) {
            if (isReversed) {
                sb.append(numbers.pollLast())
                        .append(" ");
            } else {
                sb.append(numbers.pollFirst())
                        .append(" ");
            }
        }

        return sb.toString()
                       .trim()
                       .replace(" ", ",") + "]";
    }
}
