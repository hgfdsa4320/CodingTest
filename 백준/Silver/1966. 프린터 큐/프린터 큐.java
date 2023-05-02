import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
            
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int tmp = Integer.parseInt(st.nextToken());
                pq.offer(tmp);
                q.offer(new int[]{j,tmp});                
            }
            int cnt=0;
            Loop1:
            while(!pq.isEmpty()){
                while(!q.isEmpty()){
                    int[] arr = q.poll();
                    if(arr[1]==pq.peek()){
                        cnt++;
                        pq.poll();
                        if(arr[0]==m){
                            System.out.println(cnt);
                            break Loop1;
                        }
                        
                    }else{
                        q.offer(new int[]{arr[0],arr[1]});
                    }
                }
            }
        }
    }
}