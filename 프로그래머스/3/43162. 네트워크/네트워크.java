class Solution {
    static boolean[] visited;
    
    static void dfs(int v,int[][] computers){
        visited[v] = true;
        for(int i=0;i<computers[v].length;i++){
            if(computers[v][i]==1 && !visited[i]){
                dfs(i,computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0;i<computers.length;i++){
            if(!visited[i]){
                dfs(i,computers);
                answer++;
            }
        }
        return answer;
    }
}