import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            int start = 0;
            int end = n-1;
            int target = arr[i];
            while(start<end){
                if(arr[start]+arr[end]==target){
                    if(start!=i && end !=i){
                        answer++;
                        break;
                    }else if(start==i){
                        start++;
                    }else{
                        end--;
                    }
                }else if(arr[start]+arr[end]<target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        System.out.println(answer);
    }
}