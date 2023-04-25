import java.io.*;
import java.util.*;

public class Main{
    static int n,k,cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs());
        
    }
    
    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        q.offer(new int[]{n,cnt});

        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            n = tmp[0];
            cnt = tmp[1];
            if(n==k){
                return cnt;
            }else{
                if(!visited.contains(n+1) && n+1<=100000){
                    visited.add(n+1);
                    q.offer(new int[]{n+1,cnt+1});                
                }
                if(!visited.contains(n-1) && n-1>=0){
                    visited.add(n-1);
                    q.offer(new int[]{n-1,cnt+1});                    
                }
                if(!visited.contains(n*2) && n*2<=100000){
                    visited.add(n*2);
                    q.offer(new int[]{n*2,cnt+1});                
                }
            }
        }
        return -1;
    }
}