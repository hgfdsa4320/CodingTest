import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a,b)-> (Math.abs(a)==Math.abs(b))?a-b:Math.abs(a)-Math.abs(b));

        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp!=0){
                pq.add(tmp);
            }else{
                if(pq.isEmpty()) 
                    System.out.println(0);
                else{
                    System.out.println(pq.poll());    
                }
                
            }

        }
    }
}