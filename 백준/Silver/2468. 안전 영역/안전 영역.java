import java.io.*;
import java.util.*;

public class Main{
    
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int max_height = 0;
        
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>max_height){
                    max_height=map[i][j];
                }
            }
        }
        int answer = 1;
        for(int h=1;h<max_height;h++){
            visited = new boolean[n][n];
            int cnt = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j]>h && !visited[i][j]){
                        cnt++;
                        dfs(i,j,h);
                    }
                }
            }
            answer = Math.max(answer,cnt);
        }
        System.out.println(answer);
    }
    static void dfs(int x, int y, int h){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && map[nx][ny]>h){
                dfs(nx,ny,h);
            }
        }
    }
}