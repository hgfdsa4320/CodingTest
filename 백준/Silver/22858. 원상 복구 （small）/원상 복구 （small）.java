import java.io.*;
import java.util.*;

public class Main{
    static int[] s;
    static int[] d;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        s = new int[n];
        d = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            s[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            d[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<k;i++){
            s = changeArr(s);
        }

        for(int i=0;i<s.length;i++) {
        	System.out.print(s[i]+" ");
        }
    }
    static int[] changeArr(int[] arr){
        int[] tmp = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            tmp[d[i]-1] = s[i];
        }
        return tmp;
    }
}