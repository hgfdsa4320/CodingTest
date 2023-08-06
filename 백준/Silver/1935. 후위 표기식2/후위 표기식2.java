import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alpha = new int[n];
        String s = br.readLine();
        Stack<Double> st = new Stack<>();
        for(int i=0;i<n;i++){
            alpha[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)){ // 한글 자음 모음, 영문자 확인 메서드
                st.push(alpha[c-'A']*1.0); //Double 원하는데 int라 1.0. 곱해줌
            }else{
                double tmp=0;
                double b = st.pop();
                double a = st.pop();
                if(c=='+'){
                    tmp = a+b;
                }else if(c=='-'){
                    tmp = a-b;
                }else if(c=='*'){
                    tmp = a*b;
                }else if(c=='/'){
                    tmp = a/b;
                }
                st.push(tmp);
            }
        }
        System.out.printf("%.2f",st.pop());
    }
}