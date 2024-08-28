/**
1. 이분 탐색으로 시간 범위 줄이기
2. 해당 시간안에 입국 심사를 할 수 있는 인원이 n이라면
-> 인원은 count = 시간/times[i]로 파악
3. 최소 시간은 
-> 시간 - (시간%time[i]의 최솟값)
**/

import java.util.*;

class Solution {
    static long min;
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 0;
        long end = 1000000000000000000L;
        
        while(start<=end){
            long mid = (start+end)/2;
            long num = findNum(n, times, mid);
            if(num==n){
                end = mid-1;
            }else if(num>n){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return start;
    }
    static long findNum(int n, int[] times, long time){
        min = Long.MAX_VALUE;
        long count = 0;
        for(int i=0;i<times.length;i++){
            count += time/times[i];
            min = Math.min(min,time%times[i]);
        }
        return count;
    }
}

