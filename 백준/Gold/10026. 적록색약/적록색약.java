import java.io.*;

public class Main{
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        Character[][] map1 = new Character[n][n];
        Character[][] map2 = new Character[n][n];
        boolean[][] visited1 = new boolean[n][n];    
        boolean[][] visited2 = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            for(int j=0;j<n;j++){
                map1[i][j]=tmp.charAt(j);
                if(tmp.charAt(j)=='R'){
                    map2[i][j]='G';
                }else{
                    map2[i][j]=tmp.charAt(j);
                }
            }
        }
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited1[i][j]){
                    cnt1++;
                    dfs(map1,visited1,i,j,map1[i][j]);
                }
                if(!visited2[i][j]){
                    cnt2++;
                    dfs(map2,visited2,i,j,map2[i][j]);
                }
            }
        }
        System.out.printf("%d %d",cnt1,cnt2);
    }
    static void dfs(Character[][] map, boolean[][] visited, int x, int y,char color){
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]==color && !visited[nx][ny]){
                dfs(map,visited,nx,ny,color);
            }
        }
        
    }
}