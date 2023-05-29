import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n,m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
        System.out.println(bfs());

    }
    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited[0][0]=true;
        q.offer(new int[]{1,0,0});
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cnt = tmp[0];
            int x = tmp[1];
            int y = tmp[2];
            if(x==n-1 && y==m-1){
                return cnt;
            }
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny]==1){
                    visited[nx][ny]=true;
                    q.offer(new int[]{cnt+1,nx,ny});
                }
            }
        }
        return -1;
    }
}