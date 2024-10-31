class Solution {
    
    static int findNum(int[] stones, int n){
        int num = 0;
        int max = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]-n<0){
                num++;
                max = Math.max(max,num);
            }else{
                num = 0;
            }
        }
        return max;
    }
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200000000;

        while(left<=right){
            //인원 수
            int mid = (left+right)/2;
            // 해당 인원수가 건널 때 가장 긴 공백 길이
            int num = findNum(stones,mid);
            if(num>=k){
                right = mid-1;
            }else{
                answer = mid;
                left = mid+1;
            }
        }
        return answer;
    }
}