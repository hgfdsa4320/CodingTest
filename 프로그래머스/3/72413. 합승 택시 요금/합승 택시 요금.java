import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[][] fareArr = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(fareArr[i],Integer.MAX_VALUE);
            fareArr[i][i] = 0;
        }
        for(int[] fare : fares){
            int q = fare[0];
            int w = fare[1];
            int price = fare[2];
            fareArr[q][w] = price;
            fareArr[w][q] = price;
        }        
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(fareArr[i][k]==Integer.MAX_VALUE)
                        continue;
                    if(fareArr[k][j]==Integer.MAX_VALUE)
                        continue;
                    if(i==j)
                        continue;
                    if(fareArr[i][k]+fareArr[k][j]<fareArr[i][j]){
                        fareArr[i][j] = fareArr[i][k]+fareArr[k][j];
                    }
                }
            }
        }
        // i로 함께 이동 후 각자 위치로
        for(int i=1;i<=n;i++){
            int price = 0;
            price+=fareArr[s][i];
            price+=fareArr[i][a];
            price+=fareArr[i][b];
            answer = Math.min(answer,price);
        }
        
        return answer;
    }
}