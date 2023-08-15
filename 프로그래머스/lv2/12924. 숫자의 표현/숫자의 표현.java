class Solution {
    public int solution(int n) {
        int answer = 0;
        int s = 1;
        int e = 1;
        int sum = e;
        while(e<n){
            if(sum==n){
                answer++;
                sum-=s++;
            } else if(sum<n){
                sum+=++e;
            } else{
                sum-=s++;
            }
        }
        return answer+1;
    }
}