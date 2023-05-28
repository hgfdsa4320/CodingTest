import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static List<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        dfs(0,0);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    
    static void dfs(int cnt, int value){
        if(cnt==n){
            list.add(value);
            return;
        }
        for(int i=1;i<10;i++){
            if(isPrime(value*10+i)){
                dfs(cnt+1,value*10+i);
            }
        }
    }
    
    static boolean isPrime(int n){
        if(n==1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}