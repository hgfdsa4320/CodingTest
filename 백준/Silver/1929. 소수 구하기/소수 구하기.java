import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        for(int i=n;i<=m;i++){
            if(findNum(i)){
                sb.append(i+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    static boolean findNum(int num){
        if(num==1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}