import java.io.*;
import java.util.*;

public class Main{
    
    static int[][] map;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int w,h;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            if(w==0 && h ==0) break;
            
            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            int cnt=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(map[i][j]==1){
                        cnt++;
                        dfs(i,j);
                    }
                }
            }
            System.out.println(cnt);
        }        
    }
    static void dfs(int x, int y){
        map[x][y]=0;
        for(int i=0;i<8;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny]==1){
                dfs(nx,ny);
            }
        }
    }
}