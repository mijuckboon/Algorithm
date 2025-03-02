import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            TreeSet<Integer> numbers = new TreeSet<>();
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                numbers.add(Integer.parseInt(br.readLine()));
            }
            StringBuilder sb = new StringBuilder();

            numbers.stream()
                    .forEach(n -> sb.append(n).append(System.lineSeparator()));

            System.out.println(sb.toString().trim());
        }
    }
}