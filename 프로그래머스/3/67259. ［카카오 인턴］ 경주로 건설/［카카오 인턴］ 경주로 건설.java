/**
방문햇는지를 int[][] visited=> visited[x][y] = x,y방문에 드는 금액
-> 이 금액보다 작은 경우에만 q에 넣기
현재 방향 d, 금액 price
**/
import java.util.*;

class Info{
    int x;
    int y;
    int d;
    int price;
    public Info(int x,int y,int d,int price){
        this.x=x;
        this.y=y;
        this.d=d;
        this.price= price;
    }
}
class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][][] visited;
    static int n;
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        n = board.length;
        visited = new int[board.length][board[0].length][4];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                Arrays.fill(visited[i][j],Integer.MAX_VALUE);    
            }
        }
        
        visited[0][0][0] = 0;
        visited[0][0][1] = 0;
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(0,0,0,0));
        q.offer(new Info(0,0,1,0));
        
        while(!q.isEmpty()){
            Info info = q.poll();
            int x = info.x;
            int y = info.y;
            int d = info.d;
            int price = info.price;
            if(x==board.length-1 && y==board[0].length-1){
                answer = Math.min(answer,price);
                System.out.println(answer);
            }else{
                for(int i=0;i<4;i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if(!isInMap(nx,ny) || board[nx][ny]==1) continue;
                    int nextPrice = price + 100 + (d==i?0:500);
                    if(nextPrice<visited[nx][ny][i]){
                        q.offer(new Info(nx,ny,i,nextPrice));
                        visited[nx][ny][i] = nextPrice;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(visited));
        return answer;
    }
    static boolean isInMap(int x,int y){
        if(x>=0 && x<n && y>=0 &&y<n) return true;
        return false;
    }
}
