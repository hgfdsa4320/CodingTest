import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static Queue<int[]> q;
    static int n,m;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        q = new LinkedList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0){
                    q.offer(new int[]{i,j,map[i][j]});
                }

            }
        }

        int size = q.size();
        int cnt = 0;
        int answer = 0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int height = tmp[2];
            cnt++;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==0 && !visited[nx][ny]){
                    height--;
                }

            }
            if(height<=0){
                visited[x][y] = true;
                map[x][y] = 0;
            }else{
                map[x][y] = height;
                q.offer(new int[]{x,y,height});
            }
            if(cnt == size){
                answer++;

                if(size>q.size() && checkArea()){
                    break;
                }
                size = q.size();
                cnt = 0;
                visited = new boolean[n][m];
            }
        }
        
        System.out.println((size==0)?0:answer);
    }
    static boolean checkArea(){
        int cnt = 0;
        checked = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]>0 && !checked[i][j]){
                    cnt++;
                    dfs(i,j);
                }
            }
        }
        if(cnt>1){
            return true;
        }else{
            return false;
        }
    }
    static void dfs(int x, int y){
        checked[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && !checked[nx][ny] && map[nx][ny]>0){
                dfs(nx,ny);
            }
        }
    }
}