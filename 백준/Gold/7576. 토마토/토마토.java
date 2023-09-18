import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int day=0;
        int[][] map = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    q.offer(new int[]{i,j,0});
                }
            }
        }

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            day = tmp[2];
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==0){
                    map[nx][ny]=1;
                    q.offer(new int[]{nx, ny, day + 1});
                }
            }
        }
        Loop1:
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0){
                    day=-1;
                    break Loop1;
                }
            }
        }
        System.out.println(day);
    }
}