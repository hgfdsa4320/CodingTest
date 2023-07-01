import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            boolean isPossible = true;
            Stack<Character> st = new Stack<>();
            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)==')'){
                    if(st.isEmpty() || st.pop()==')'){
                        isPossible = false;
                        break;
                    }
                }else{
                    st.push('(');
                }
            }
            if(!st.isEmpty()){
                isPossible = false;
            }
            if(isPossible){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}