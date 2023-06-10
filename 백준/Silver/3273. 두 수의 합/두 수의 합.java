import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        int answer = 0;
        while(start<end){
            int value = arr[start]+arr[end];
            if(value>x){
                end--;
            }else if(value<x){
                start++;
            }else{
                answer++;
                start++;
                end--;
            }
        }
        System.out.println(answer);
    }
}