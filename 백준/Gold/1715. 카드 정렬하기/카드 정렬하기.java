import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer=0;
        while(pq.size()>=2){
            int tmp = pq.poll()+pq.poll();
            answer+=tmp;
            pq.offer(tmp);
        }
        System.out.println(answer);
    }
}