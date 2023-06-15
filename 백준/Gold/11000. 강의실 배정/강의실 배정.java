import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i][0] = s;
            arr[i][1] = e;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for(int i=0;i<n;i++){
            int s = arr[i][0];
            int e = arr[i][1];
            while(!pq.isEmpty() && pq.peek()<=s){
                pq.poll();
            }
            pq.add(e);
            answer = Math.max(answer,pq.size());
        }
        System.out.println(answer);
    }
}