import java.io.*;
import java.util.*;

public class Main{
    static int[][] graph;
    static int[] dx;
    static int[] dy;
    static int n,m;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        dx = new int[]{1,0,-1,0};
        dy = new int[]{0,1,0,-1};
        
        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            for(int j=0;j<m;j++){
                graph[i][j]= tmp.charAt(j)-'0';
            }
        }
    
        System.out.println(bfs(0,0,1));
    }
    
    static int bfs(int x, int y, int now){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,now});
        graph[x][y]=0;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            x = arr[0];
            y = arr[1];
            now = arr[2];
            if(x==n-1 && y==m-1){
                return now;
            }
            
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && graph[nx][ny]==1){
                    graph[nx][ny]=0;
                    q.offer(new int[]{nx,ny,now+1});
                }
            }
        }
        return -1;
    }
}