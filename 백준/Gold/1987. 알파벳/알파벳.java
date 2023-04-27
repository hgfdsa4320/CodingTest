import java.io.*;
import java.util.*;

public class Main{
    
    static Character[][] map;
    static boolean[] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int r,c;
    static int answer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new Character[r][c];
        visited = new boolean[26];
        
        for(int i=0;i<r;i++){
            String tmp = br.readLine();
            for(int j=0;j<c;j++){
                map[i][j] = tmp.charAt(j);
            }
        }
        
        dfs(0,0,1);
        System.out.println(answer);
    }
    
    static void dfs(int x, int y, int cnt){
        visited[map[x][y]-'A']=true;
        answer = Math.max(answer,cnt);
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<r && ny>=0 && ny<c && !visited[map[nx][ny]-'A']){    
                dfs(nx,ny,cnt+1);
                visited[map[nx][ny]-'A']=false;
                
            }
        }
    }
}