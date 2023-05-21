import java.util.*;

class Solution {
    static boolean[][] visited;
    static ArrayList<Integer> res;
    static int cnt;
    static int n,m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        res = new ArrayList<>();
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j)!='X' && !visited[i][j]){
                    cnt = 0;
                    dfs(maps,i,j);
                    res.add(cnt);
                }
            }
        }
        if(res.size()==0) return new int[]{-1};
        int[] answer = new int[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    static void dfs(String[] maps, int x, int y){
        visited[x][y]=true;
        cnt+=maps[x].charAt(y)-'0';
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && maps[nx].charAt(ny)!='X'){
                dfs(maps,nx,ny);
            }
        }
    }
}