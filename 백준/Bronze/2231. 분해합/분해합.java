import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int number = Integer.parseInt(input);
        for (int i = 1; i < number; i++) {
            if (number == getSeparateSum(String.valueOf(i))) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);

    }

    public static int getSeparateSum(String number) {
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .mapToInt(x -> x)
                .sum() + Integer.parseInt(number);
    }
}
