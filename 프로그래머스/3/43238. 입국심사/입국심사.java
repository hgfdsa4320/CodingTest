class Solution {
    
    static long findNum(int[] times, long mid){
        long cnt = 0;
        for(int i=0;i<times.length;i++){
            cnt+=mid/times[i];
        }
        return cnt;
    }
    public long solution(int n, int[] times) {
        long answer = 0;
        long left =1;
        long right = 100000000000000L;
        
        while(left<=right){
            long mid = (left+right)/2;
            long num = findNum(times,mid);
            if(num>=n){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }
}