class Solution {
    static int answer;
    static boolean[] checked;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        checked = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        return answer;
    }
    static void dfs(int k, int[][] dungeons, int cnt){
        answer = Math.max(answer,cnt);
        for(int i=0;i<dungeons.length;i++){
            if(!checked[i] && k>=dungeons[i][0]){
                checked[i]=true;
                dfs(k-dungeons[i][1],dungeons,cnt+1);
                checked[i]=false;
            }
        }
    }
}