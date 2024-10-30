class Solution {
    static int answer;
    
    static void dfs(int[] numbers, int cnt, int now, int target){
        if(cnt==numbers.length){
            if(now==target)
                answer++;
            return;
        }
        dfs(numbers,cnt+1,now+numbers[cnt],target);
        dfs(numbers,cnt+1,now-numbers[cnt],target);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers,0,0,target);
        return answer;
    }
}