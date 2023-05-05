import java.io.*;
import java.util.*;

public class Main{
    static int n,m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        answer = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=true;
                dfs(1,map[i][j],i,j);
                visited[i][j]=false;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m-2;j++){
                answer = Math.max(answer,map[i][j]+map[i-1][j+1]+map[i][j+1]+map[i][j+2]);
            }
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-2;j++){
                answer = Math.max(answer,map[i][j]+map[i+1][j+1]+map[i][j+1]+map[i][j+2]);
            }
        }
        for(int i=0;i<n-2;i++){
            for(int j=1;j<m;j++){
                answer = Math.max(answer,map[i][j]+map[i+1][j]+map[i+1][j-1]+map[i+2][j]);
            }
        }
        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-1;j++){
                answer = Math.max(answer,map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+2][j]);
            }
        }
        System.out.println(answer);
    }
    static void dfs(int cnt, int sum, int x, int y){
        if(cnt==4){
            answer = Math.max(answer,sum);
        }else{
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(cnt+1,sum+map[nx][ny],nx,ny);
                    visited[nx][ny] = false;
                }
            }
        }

    }
}