import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0;tc<t;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new LinkedList<>(); //{인덱스, 값}
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                int tmp = Integer.parseInt(st.nextToken());
                q.offer(new int[]{i,tmp});
                pq.offer(tmp);
            }
            int cnt = 1;
            while(true){
                int[] arr = q.poll();                
                if(arr[1]==pq.peek()){
                    if(arr[0]==m){
                        break;
                    }else{
                        pq.poll();
                        cnt++;
                    }
                }else{
                    q.offer(arr);
                }
            }
            System.out.println(cnt);
        }
    }
}