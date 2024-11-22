class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int end = 1;
        int now = 1;
        while(start<=end){
            if(now==n){
                answer++;
                now-=start++;
                now+=++end;
            }else if(now<n){
                now+=++end;
            }else{
                now-=start++;
            }
        }
        return answer;
    }
}