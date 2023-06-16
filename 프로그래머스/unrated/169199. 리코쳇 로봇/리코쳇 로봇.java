import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static char[][] map;
    static int n,m,answer;
    public int solution(String[] board) {
        answer = 0;
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        int x = 0;
        int y = 0;
        for(int i=0;i<n;i++){
            String tmp = board[i];
            for(int j=0;j<m;j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j]=='R'){
                    x=i;
                    y=j;
                }
            }
        }
        bfs(x,y);
        
        
        return (answer==0)?-1:answer;
    }
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>(); // {x,y,cnt}
        q.offer(new int[]{x,y,0});
        visited[x][y]=true;
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            int cnt = tmp[2];
            if(map[x][y]=='G'){
                answer = cnt;
                break;
            }
            for(int i=0;i<4;i++){
                int nx = x;
                int ny = y;
                while(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]!='D'){
                    nx+=dx[i];
                    ny+=dy[i];
                }
                nx-=dx[i];
                ny-=dy[i];
                if(!visited[nx][ny]){
                    q.offer(new int[]{nx,ny,cnt+1});
                    visited[nx][ny]=true;
                }
            }
        }
    }
}