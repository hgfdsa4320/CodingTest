import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i]>stack.peek()[1]){
                int[] tmp = stack.pop();
                answer[tmp[0]] = arr[i];
            }
            stack.push(new int[]{i,arr[i]});
        }
        while(!stack.isEmpty()){
            int[] tmp = stack.pop();
            answer[tmp[0]] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : answer){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}