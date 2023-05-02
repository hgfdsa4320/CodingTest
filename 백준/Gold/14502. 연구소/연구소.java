import java.io.*;
import java.util.*;

public class Main{
    static int n,m;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(answer);
    }
    static void dfs(int wall){
        if(wall==3){
            bfs();
        }else{
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]==0){
                        map[i][j]=1;
                        dfs(wall+1);
                        map[i][j]=0;
                    }
                }
            }
        }
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            arr[i] = map[i].clone();
        }
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]==0){
                    arr[nx][ny]=2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        answer = Math.max(answer,getCount(arr));
    }
    static int getCount(int[][] arr){
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}