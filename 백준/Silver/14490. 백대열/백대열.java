import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int a = Integer.parseInt(s.split(":")[0]);
        int b = Integer.parseInt(s.split(":")[1]);

        int k = gcd(a,b);
        a/=k;
        b/=k;
        System.out.println(""+a+":"+b);
    }

    static int gcd(int a, int b){
        if(b>a){
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(b==0) return a;
        return gcd(b,a%b);
    }
}