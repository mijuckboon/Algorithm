import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            Stack<Character> stick = new Stack<>();
            
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' ) {
                stick.push(ch);
            }
            if (ch == ')') {
                stick.pop();
                if (i >= 1) {
                    char prev = input.charAt(i - 1);
                    if (prev == '(') {
                        counter += stick.size();
                    } else {
                        counter += 1;
                    }
                }
            }
        }
        System.out.println(counter); 
        }
    }
}