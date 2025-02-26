import java.util.Scanner;

public class Main {
    static final int MOD = 1234567891;
    static final int PRIME = 31;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int len = Integer.parseInt(sc.nextLine());
        final String input = sc.nextLine();
        long sum = 0;
        for (int i = len-1; i >= 0; i--) {
            int alphabet = input.charAt(i) - 'a' + 1;
            sum = (sum * PRIME) % MOD;
            sum = (sum + alphabet) % MOD;
        }
        System.out.println(sum);
    }
}