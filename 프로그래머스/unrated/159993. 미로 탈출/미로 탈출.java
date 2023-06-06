import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    static boolean[][] visited;
    public int solution(String[] maps) {
        
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        int startX=0;
        int startY=0;
        int leverX=0;
        int leverY=0;
        int endX=0;
        int endY=0;
        for(int i=0;i<map.length;i++){
            String tmp = maps[i];
            for(int j=0;j<map[0].length;j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j]=='S'){
                    startX=i;
                    startY=j;
                }else if(map[i][j]=='L'){
                    leverX=i;
                    leverY=j;
                }else if(map[i][j]=='E'){
                    endX=i;
                    endY=j;
                }
            }
        }
        //둘 중 하나라도 못가면 -1 return
        int a = bfs(startX,startY,leverX,leverY);
        visited = new boolean[maps.length][maps[0].length()];
        int b = bfs(leverX,leverY,endX,endY);
        if(a==-1 || b==-1) return -1;
       
        int answer = a+b;
        return answer;
    }
    
    static int bfs(int x, int y, int targetX, int targetY){
        Queue<int[]> q = new LinkedList<>(); // {x,y, 횟수}
        q.offer(new int[]{x,y,0});
        visited[x][y]=true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            int cnt = tmp[2];
            if(x==targetX && y==targetY) return cnt;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<map.length && ny>= 0 && ny<map[0].length && map[nx][ny]!='X' 
                   && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny,cnt+1});
                }
            }
        }
        return -1;
    }
}