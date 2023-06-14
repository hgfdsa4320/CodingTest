class Solution {
    static int answer;
    static int target;
    static boolean[] visited;
    static int[] arr;
    public int solution(int n) {
        answer = 0;
        target = n;
        visited = new boolean[n];
        arr = new int[n];
        dfs(0);
        return answer;
    }
    static void dfs(int cnt){
        if(cnt==target) {
            answer++;
            return;
        }
        for(int i=0;i<target;i++){
            if(!visited[i]){
                boolean isOkay = true;
                for(int j=0;j<cnt;j++){
                    if(Math.abs(cnt-j)==Math.abs(i-arr[j])){
                        isOkay = false;
                        break;
                    }
                }
                if(isOkay){
                    visited[i] = true;
                    arr[cnt] = i; 
                    dfs(cnt+1);
                    visited[i]=false;
                }
                
            }
        }
        
    }
}