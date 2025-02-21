import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String trimed = input.trim();
        String[] tokens = trimed.split(" ");
        System.out.println(!trimed.isEmpty() ? tokens.length : 0);
    }
}

