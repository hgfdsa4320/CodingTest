class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long distance = (long)Math.pow(d,2);
        for(int i=0;i<=d/k;i++){
            long possibleDistance = distance - (long)Math.pow(i*k,2);
            long cnt = (long)Math.sqrt(possibleDistance)/k+1;
            answer+=cnt;
            
        }
        return answer;
    }
}