import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int answer=0;
        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp<=0){
                minus.add(tmp);
            }else{
                plus.add(tmp);
            }
        }
        
        while(plus.size()>=2){
            n = plus.poll();
            int next = plus.poll();
            if(n*next>n+next){
                answer+=n*next;
            }else{
                answer+=n+next;
            }
        }
        if(!plus.isEmpty()) answer+=plus.poll();
        
        while(minus.size()>=2){
            n = minus.poll();
            int next = minus.poll();
            if(n*next>n+next){
                answer+=n*next;
            }else{
                answer+=n+next;
            }
        }
        if(!minus.isEmpty()) answer+=minus.poll();
        
        System.out.println(answer);
    }
}