import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long previous = arr[0];
        long max = arr[0];
        int maxCnt = 1;
        int cnt = 1;
        for(int i=1;i<n;i++){
            if(arr[i]==previous) {
                cnt++;
            }else{
                cnt = 1;
            }
            previous = arr[i];
            if(cnt>maxCnt){
                max = arr[i];
                maxCnt = cnt;
            }
        }
        System.out.println(max);
    }
}