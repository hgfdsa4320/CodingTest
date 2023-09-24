import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '<') {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                } else if (c == '>') {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else if (c == '-') {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                } else {
                    leftStack.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!leftStack.isEmpty()) {
                sb.append(leftStack.pop());
            }
            sb.reverse();
            while (!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }
            System.out.println(sb);
        }

    }
}