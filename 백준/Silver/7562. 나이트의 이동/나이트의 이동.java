import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[][] map;
    static int[] dx = {2,2,1,1,-1,-1,-2,-2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i=0;i<t;i++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            System.out.println(bfs(x1,y1,x2,y2));
        }
    }
    
    static int bfs(int x1,int y1, int x2,int y2){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1,y1,0});
        visited[x1][y1]=true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            x1 = tmp[0];
            y1 = tmp[1];
            int cnt = tmp[2];
            if(x1 == x2 && y1 == y2){
                return cnt;
            }
            for(int i=0;i<8;i++){
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n &&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny,cnt+1});
                }
            }
        }
        return -1;
    }
}