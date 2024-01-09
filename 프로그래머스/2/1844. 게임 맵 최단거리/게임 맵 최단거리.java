import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int bfs(int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        
        isVisited[0][0] = true;
        queue.add(new int[] {0, 0, 1});
        
        int cnt = 0;
        int i = 0;
        int j = 0;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int c = poll[2];
            if(x==n && y==m) return c;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= maps.length || nx < 0 || ny >= maps[0].length || ny < 0) continue;
                if (isVisited[nx][ny]) continue;
                if (maps[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny, c+1});
                    isVisited[nx][ny] = true;
                    cnt = c+1;
                    
                }
            }
        }
        
        if (i == n && j == m) {
            return cnt;
        }
        
        return -1;
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = bfs(maps);
        
        return answer;
    }
}