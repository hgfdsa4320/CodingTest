import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        
        int left = 0;
        int right = n-1;
        long answer = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        long[] res = {arr[left],arr[right]};
        while(left<right){
        	
            if(Math.abs(arr[left]+arr[right])<=answer){
                res[0] = arr[left];
                res[1] = arr[right];

                answer = Math.min(answer,Math.abs(arr[left]+arr[right]));
            }
            
            if(arr[left]+arr[right]<0){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(res[0]+" "+res[1]);
    }
}