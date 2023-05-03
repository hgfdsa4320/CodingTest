import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb;
        StringBuilder res = new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='<'){
                sb = new StringBuilder();
                sb.append("<");
                i++;
                while(i<s.length() && s.charAt(i)!='>'){
                    sb.append(s.charAt(i)+"");
                    i++;
                }
                sb.append(">");
                i++;
                res.append(sb.toString());
            }else if(s.charAt(i)!=' '){
                Stack<String> stack = new Stack<>();
                stack.push(s.charAt(i)+"");
                i++;
                while(i<s.length() && s.charAt(i)!=' ' && s.charAt(i)!='<'){
                    stack.push(s.charAt(i)+"");
                    i++;
                }
                sb = new StringBuilder();
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                res.append(sb.toString());
            }else if(s.charAt(i)==' '){
                res.append(" ");
                i++;
            }
        }
        System.out.println(res.toString());
    }
}