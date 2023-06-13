import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = arr[start];
        while(end<n){
            if(sum>=s){
                answer = Math.min(answer,end-start+1);
                sum-=arr[start++];
            }else{
                if(end==n-1) break;
                sum+=arr[++end];
            }

        }
        if(answer==Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(answer);            
        }

    }
}