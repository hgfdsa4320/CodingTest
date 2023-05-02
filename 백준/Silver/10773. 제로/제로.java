import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<k;i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp==0){
                stack.pop();
            }else{
                stack.push(tmp);
            }
        }
        int answer=0;
        for(Integer i : stack){
            answer+=i;
        }
        System.out.println(answer);
    }
}