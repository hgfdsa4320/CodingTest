import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(a,b)->a[1]-b[1]);
        int start = routes[0][1];
        int end = routes[0][1];
        answer++;
        for(int i=1;i<routes.length;i++){
            if((routes[i][0]>=start && routes[i][0]<=end) || (routes[i][1]>=start && routes[i][1]<=end)){
                continue;
            }else if((start>=routes[i][0]&&start<=routes[i][1]) ||(end>=routes[i][0] && end<=routes[i][1])){
                continue;
            }else{
                answer++;
                end = routes[i][1];
            }
        }
        return answer;
    }
}