import java.util.*;

class Solution {
    
    // 시계 방향으로 90도 회전
    static int[][] rotateKey(int[][] key){
        int n = key.length;
        int[][] tmpMap = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tmpMap[i][j] = key[n-j-1][i];
            }
        }
        return tmpMap;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        
        int[][] map = new int[n+(m-1)*2][n+(m-1)*2];
        
        for(int i=m-1;i<m+n-1;i++){
            for(int j=m-1;j<m+n-1;j++){
                map[i][j] = lock[i-m+1][j-m+1];
            }
        }
        
        
        
        for(int i=0;i<=3;i++){
            for(int j=0;j<i;j++){
                key = rotateKey(key);
            }
            
            for(int j=0;j<m+n-1;j++){
                for(int k=0;k<m+n-1;k++){
                    int[][] tmpMap = new int[n+(m-1)*2][n+(m-1)*2];
                    for(int l=j;l<j+m;l++){
                        for(int o=k;o<k+m;o++){
                            tmpMap[l][o] = key[l-j][o-k];
                        }
                    }
                    
                    boolean isPossible = true;
                    for(int l=m-1;l<m+n-1;l++){
                        for(int o=m-1;o<m+n-1;o++){
                            if(map[l][o]==1){
                                if(tmpMap[l][o]==1){
                                    isPossible = false;
                                    break;
                                }
                            }else{
                                if(tmpMap[l][o]==0){
                                    isPossible = false;
                                    break;
                                }
                            }
                        }
                        if(!isPossible) break;
                    }
                    if(isPossible) return true;
                }
            }
        }
        
        
        return false;
    }
}

/**

[0, 0, 0], 
[1, 0, 0], 
[0, 1, 1]
**/