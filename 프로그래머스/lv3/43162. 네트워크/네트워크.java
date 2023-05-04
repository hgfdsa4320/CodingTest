class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer++;
                dfs(i,computers);
            }
        }
        return answer;
    }
    
    static void dfs(int v, int[][] computers){
        visited[v]=true;
        for(int i=0;i<computers.length;i++){
            if(computers[v][i]==1 && !visited[i]){
                dfs(i,computers);
            }
        }
    }
    
}