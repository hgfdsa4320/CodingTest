import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean answer = true;
        Stack<Integer> st = new Stack<>();
        int j = 1;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            while (j <= num) {
                st.push(j);
                sb.append("+").append("\n");
                j++;
            }
            if (!st.isEmpty() && st.pop() == num) {
                sb.append("-").append("\n");
            } else {
                answer = false;
                break;
            }
        }
        if (answer) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }


    }
}