/*
dp?
아니면 홀수, 짝수 누적합?

*/
import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long[][] dp = new long[sequence.length+1][2];
        for(int i=1;i<=sequence.length;i++){
            //짝수이면 
            if(i%2==0){
                dp[i][0] = Math.max(sequence[i-1],dp[i-1][0]+sequence[i-1]);
                dp[i][1] = Math.max(-sequence[i-1],dp[i-1][1]-sequence[i-1]);
            }else{
                dp[i][0] = Math.max(-sequence[i-1],dp[i-1][0]-sequence[i-1]);
                dp[i][1] = Math.max(sequence[i-1],dp[i-1][1]+sequence[i-1]);
            }
        }
        for(int i=1;i<=sequence.length;i++){
            for(int j=0;j<2;j++){
                answer = Math.max(answer,dp[i][j]);
            }
        }
        
        return answer;
    }
}
