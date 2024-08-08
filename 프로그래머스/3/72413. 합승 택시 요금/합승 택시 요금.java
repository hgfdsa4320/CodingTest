/**
지점 개수 -> 200이하
플로이드 워샬 -> 모든 지점에서 다른 지점으로 갈 수 있는 최단거리 다 구해놓기
S에서 갈 수 있는 모든 지점 + 그 지점에서의 A로가는 거리 + B로가는 거리의 합 들 중 최솟값
**/
import java.util.*;

class Solution {
    static int[][] distance;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        distance = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<fares.length;i++){
            int q = fares[i][0];
            int w = fares[i][1];
            int e = fares[i][2];
            distance[q][w] = e;
            distance[w][q] = e;
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i==j) distance[i][j] = 0;
                    if(distance[i][k]==Integer.MAX_VALUE ||distance[k][j]==Integer.MAX_VALUE) 
                        continue;
                    if(distance[i][k]+distance[k][j]<distance[i][j])
                        distance[i][j] = distance[i][k]+distance[k][j];
                }
            }
        }
        for(int i=1;i<=n;i++){
            int q = distance[s][i];
            int w = distance[i][a];
            int e = distance[i][b];
            if(q!=Integer.MAX_VALUE && w!=Integer.MAX_VALUE && e!=Integer.MAX_VALUE)
                answer = Math.min(answer,q+w+e);
        }
        return answer;
    }
}