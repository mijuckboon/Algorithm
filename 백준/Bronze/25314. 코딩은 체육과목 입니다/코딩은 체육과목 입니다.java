import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int long_cnt = input.nextInt();
        long_cnt /= 4; //4의 

        String output = "long ".repeat(Math.max(0, long_cnt)) +
                "int";
        System.out.println(output);
    }
}