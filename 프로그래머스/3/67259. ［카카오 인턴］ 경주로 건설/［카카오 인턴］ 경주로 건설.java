import java.util.*;

class QInput{
    int x;
    int y;
    int d;
    int price;
    
    public QInput(int x,int y,int d,int price){
        this.x=x;
        this.y=y;
        this.d=d;
        this.price= price;
    }
}

class Solution {
    static int[] dx = {1,-1,0,0};// 하 상 우 좌
    static int[] dy = {0,0,1,-1};
    static int n;
    
    static boolean isInMap(int x,int y){
        if(x>=0 && x<n && y>=0 && y<n) return true;
        return false;
    }
    
    public int solution(int[][] board) {
        n = board.length;
        int[][][] visited= new int[n][n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        Queue<QInput> q = new LinkedList<>();
        q.offer(new QInput(0,0,2,0));
        visited[0][0][2] = 0;
        q.offer(new QInput(0,0,0,0));
        visited[0][0][0] = 0; 
        
        int answer = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            QInput p = q.poll();
            int x = p.x;
            int y = p.y;
            int d = p.d;
            int price = p.price;
            if(x==n-1 && y==n-1){
                answer = Math.min(answer,price);
            }
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(!isInMap(nx,ny) || board[nx][ny]==1)
                    continue;
                int nextPrice = price+(i==d?100:600);
                if(visited[nx][ny][i]>nextPrice){
                    visited[nx][ny][i] = nextPrice;
                    q.offer(new QInput(nx,ny,i,nextPrice));
                }
            }
        }
        return answer;
        
    }
}