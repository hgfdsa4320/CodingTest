class Solution {
    static boolean[] visited;
    static int n;
    static int answer;
    
    
    static void findNum(int now, int k,int cnt,int[][] dungeons){
        answer = Math.max(answer,cnt);
        for(int i=0;i<n;i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                findNum(i,k-dungeons[i][1],cnt+1,dungeons);
                visited[i] = false;    
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        n = dungeons.length;
        visited = new boolean[n];
        for(int i=0;i<dungeons.length;i++){
            if(k>=dungeons[i][0]){
                visited[i] = true;
                findNum(i,k-dungeons[i][1],1,dungeons);
                visited[i] = false;    
            }
        }
        
        return answer;
    }
}