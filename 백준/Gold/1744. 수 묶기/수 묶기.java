import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        while(pq.size()>=2){
            int a = pq.peek();
            if(a>=0) break;
            pq.poll();
            int b = pq.peek();
            if(b>0) {
                pq.add(a);
                break;
            }
            pq.poll();
            answer+=a*b;
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)->b-a);
        while(!pq.isEmpty()){
            pq2.add(pq.poll());
        }
        while(pq2.size()>=2){
            int tmp = 0;
            int a = pq2.poll();
            int b = pq2.poll();
            if (a <= 1 || b <= 1 ) {
                tmp = a + b;
            } else {
                tmp = a * b;
            }
            answer+=tmp;
        }
        while(!pq2.isEmpty()){
            answer+=pq2.poll();
        }
        System.out.println(answer);
    }
}