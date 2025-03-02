import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Set<Integer> numbers = new HashSet<>();
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                numbers.add(Integer.parseInt(br.readLine()));
            }
            
            StringBuilder sb = new StringBuilder();
            
            numbers.stream()
                    .sorted(Comparator.naturalOrder())
                    .forEach(n -> sb.append(n).append(System.lineSeparator()));

            System.out.println(sb.toString().trim());
        }
    }
}