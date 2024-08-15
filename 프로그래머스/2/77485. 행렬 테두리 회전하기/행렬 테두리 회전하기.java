/**
제일 크게 돌아도 대략 400번
쿼리도 10000이하이므로 시간 초과 x
1. 행렬 만들기
2. 돌리는 함수 만들기 -> 돌리면서 가장 작은 값 리턴하는

int rotate(x1,y1,x2,y2) -> 
시작 점 : map[x1][y1]을 tmp에 저장
x1,y1에서 시작해서 반시계 방향으로 값을 각각 저장
Ex) map[x1][y1] = map[x1-1][y1]
map[x1-1][y1] = map[x1-2][y1] 
...
이거를 나타내는 방향d와 범위 구해서 하면 됨
방향은 아래, 오른쪽, 위, 왼쪽(반시계)
**/

import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int[] answer;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        map = new int[rows+1][columns+1];
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                map[i][j] = (i-1)*columns+j;
            }
        }
        int idx = 0;
        for(int[] query : queries){
            answer[idx++] = rotate(query);
        }
        return answer;
    }
    static int rotate(int[] query){
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];
        int tmp = map[x1][y1];
        int d = 0;
        int min = tmp;
        int x = x1;
        int y = y1;
        while(true){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(isInMap(nx,ny,query)){
                map[x][y] = map[nx][ny];
                x = nx;
                y = ny;
                if(map[x][y]<min) min = map[x][y];
            }else{
                d = d + 1;
                if(d==4) break;
            }
        }
        map[x1][y+1] = tmp;
        return min; 
    }
    static boolean isInMap(int x,int y,int[] query){
        if(x>=query[0] && x<=query[2] && y>=query[1] && y<=query[3]) return true;
        return false;
    }
}