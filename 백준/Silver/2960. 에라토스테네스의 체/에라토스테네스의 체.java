import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n+1];
        int cnt = 0;
        Loop1:
        for(int i=2;i<=n;i++){
            if(arr[i]) continue;
            for(int j=i;j<=n;j+=i){
                if(!arr[j]){
                    arr[j]=true;
                    cnt++;
                    if(cnt==k){
                        System.out.println(j);
                        break Loop1;
                    }
                }
            }
        }
    }
}