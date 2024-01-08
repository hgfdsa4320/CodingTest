import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        
        visited = new boolean[maps.length][maps[0].length];
        bfs(maps);
        int answer = (maps[maps.length-1][maps[0].length-1]==1)?-1: maps[maps.length-1][maps[0].length-1];
        return answer;
    }
    static void bfs(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0]=true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length){ 
                    if(!visited[nx][ny] && maps[nx][ny]==1){ // 방문하지 않았고, 길이라면
                        maps[nx][ny]=maps[x][y]+1;
                        visited[nx][ny]=true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}