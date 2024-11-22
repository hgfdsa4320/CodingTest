import java.util.*;

class Solution {
    
    static long findTime(int now, int[] diffs, int[] times){
        long time = 0;
        for(int i=0;i<diffs.length;i++){
            if(diffs[i]<=now){
                time+=times[i];
            }else{
                int prevTime = i==0?0:times[i-1];
                time += times[i] + (times[i]+prevTime)*(diffs[i]-now);
            }
        }
        return time;
    }
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 1;
        int end = 100000;
        while(start<=end){
            int now = (start+end)/2;
            long time = findTime(now,diffs,times);
            if(time>limit){
                start = now+1;
            }else{
                answer = now;
                end = now-1;
            }
        }
        return answer;
    }
}