/**
방향을 오른쪽이랑 밑에만 파악해서 2이내의 거리에 파티션 없이 도달할 수 있는게 있는지 확인
-> 5 x 5이므로 전부 다 해도 몇개안됨
for문으로 모든 좌표에서 확인
한 지점에서 isPossible(int x, int y, int cnt) -> 확인
1. x,y가 범위를 벗어날 경우 return false;
2. x,y가 파티션일 경우 -> return false;
3. x,y가 빈 공간일 경우 -> cnt==2면 return false, 1이면 오른쪽 아래쪽 호출
4. x,y가 사람일 경우 -> return true; 
**/
import java.util.*;

class Solution {
    static boolean isNotRule;
    static int[] dx = {1,0,0};
    static int[] dy = {0,1,-1};
    static char[][] map;
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        
        for(int c=0;c<5;c++){
            map = new char[5][5];
            isNotRule = false;
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    map[i][j] = places[c][i].charAt(j);
                }
            }
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(map[i][j]=='P'){
                        for(int k=0;k<3;k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            isPossible(i,j,nx,ny,1);
                        }
                        if(isNotRule) {
                            answer[c] = 0;   
                            break;
                        }       
                    }        
                }
                if(isNotRule) break;
            }
        }
        return answer;
    }
    static void isPossible(int sx,int sy,int x, int y, int cnt){
        if(!isInMap(x,y)) return;
        if(map[x][y]=='X'){
            return;
        }
        if(map[x][y]=='O'){
            if(cnt==2) return;
            for(int i=0;i<3;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                isPossible(sx,sy,nx,ny,cnt+1);
            }
        }else{
            if(sx==x && sy==y) return;
            isNotRule = true;
        }
    }
    static boolean isInMap(int x,int y){
        if(x>=0 && x<5 && y>=0 &&y<5) return true;
        return false;
    }
}