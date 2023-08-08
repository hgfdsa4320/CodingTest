import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(" ");
        int now = 0;
        visited[now] = true;
        for(int i=1;i<n;i++){ // 처음 시작은 넣어줬으므로 n-1번 반복
            int cnt = arr[now];
            while(cnt>0){
                now = now==n-1? 0 : now+1;
                if(!visited[now]){
                    cnt--;
                }
                
            }

            while(cnt<0){
                now = now==0? n-1 : now-1;
                if(!visited[now]){
                    cnt++;
                }
            }
            visited[now] = true;
            sb.append(now+1).append(" ");
            
        }
        System.out.println(sb);
    }
}