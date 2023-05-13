import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        sb.append("+").append("\n");
        int idx = 0;
        for(int i=2;i<=n;i++){
            while(!stack.isEmpty() && stack.peek()==arr[idx]){
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            }
            stack.push(i);
            sb.append("+").append("\n");
        }
        while (!stack.isEmpty() && stack.peek()==arr[idx]) {
            stack.pop();
            sb.append("-").append("\n");
            idx++;
        }
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb.toString());
        }

    }

}