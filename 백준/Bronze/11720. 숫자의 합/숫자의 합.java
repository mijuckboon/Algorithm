import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        int sum = 0;
        for (char character : chars) {
            sum += Integer.parseInt(Character.toString(character));
        }
        System.out.println(sum);

    }
}