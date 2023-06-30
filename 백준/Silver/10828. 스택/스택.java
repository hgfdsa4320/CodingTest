import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            if(tmp.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }else if(tmp.equals("pop")){
                if(!stack.empty()){
                    System.out.println(stack.pop());
                }else{
                    System.out.println(-1);
                }
            }else if(tmp.equals("size")){
                System.out.println(stack.size());
            }else if(tmp.equals("empty")){
                if(stack.empty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else{
                if(!stack.empty()){
                    System.out.println(stack.peek());
                }else{
                    System.out.println(-1);
                }
            }
        }
    }
}