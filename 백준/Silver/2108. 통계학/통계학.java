import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int len = Integer.parseInt(br.readLine());
            int[] numbers = new int[len];
            for (int i = 0; i < len; i++){
                numbers[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(numbers);
            Map<Integer, Integer> count = new HashMap<>();
            int maxCount = 0;
            for (int number : numbers) {
                if (count.containsKey(number)) {
                    count.put(number, count.get(number) + 1);
                } else {
                    count.put(number, 1);
                }
                maxCount = Math.max(count.get(number), maxCount);
            }

            final int max = maxCount;

            int mean = (int) Math.round( (double) Arrays.stream(numbers).sum() / numbers.length);
            int median = numbers[numbers.length/2];
            int[] modes = count.entrySet().stream()
                    .filter(x -> count.get(x.getKey()) == max)
                    .mapToInt(x -> x.getKey())
                    .toArray();
            Arrays.sort(modes);
            int mode = modes[Math.min(modes.length - 1, 1)];
            int range = numbers[numbers.length - 1] - numbers[0];

            System.out.println(mean);
            System.out.println(median);
            System.out.println(mode);
            System.out.println(range);
        }
    }
}