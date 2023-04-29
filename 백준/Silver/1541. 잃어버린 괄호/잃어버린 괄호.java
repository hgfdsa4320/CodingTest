import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] nums = s.split("[+-]");
        s = s.replaceAll("[0-9]","");
        char[] operators = new char[s.length()];
        for(int i=0;i<s.length();i++){
            operators[i] = s.charAt(i);
        }
        char prev = '+';
        int answer=Integer.parseInt(nums[0]);
        for(int i=0;i<operators.length;i++){
            char now = operators[i];
            if(prev=='+'){
                if(now=='+'){
                    answer+=Integer.parseInt(nums[i+1]);
                }else{
                    answer-=Integer.parseInt(nums[i+1]);
                    prev='-';
                }
            }else{
                answer-=Integer.parseInt(nums[i+1]);
            }
        }
        System.out.println(answer);
    }
}