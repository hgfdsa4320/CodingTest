import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(s.length()%2!=0){
            System.out.println(0);
            return;
        }
        int answer = 0;
        int tmp = 1;
        boolean flag = false;
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
                flag=true;
                tmp*=2;
            }else if(s.charAt(i)=='['){
                stack.push('[');
                flag=true;
                tmp*=3;
            }else if(s.charAt(i)==')'){
                if(stack.isEmpty()||stack.pop()!='('){
                    answer = 0;
                    break;
                }
                if(flag){
                    answer+=tmp;                    
                }
                flag=false;
                tmp/=2;
            }else{
                if(stack.isEmpty()||stack.pop()!='['){
                    answer = 0;
                    break;
                }
                if(flag){
                    answer+=tmp;                    
                }
                flag=false;
                tmp/=3;
            }
        }
        System.out.println(answer);        
    }
}