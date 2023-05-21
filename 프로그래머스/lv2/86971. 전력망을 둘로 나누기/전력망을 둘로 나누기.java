import java.util.*;

class Solution {
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static int cnt;
    public int solution(int n, int[][] wires) {
        
        for(int i=0;i<wires.length;i++){
            map = new ArrayList[n+1];
            visited = new boolean[n+1];
            for(int j=1;j<=n;j++){
                map[j] = new ArrayList<>();
            }
            
            
            for(int j=0;j<wires.length;j++){
                if(j==i) continue;
                map[wires[j][0]].add(wires[j][1]);
                map[wires[j][1]].add(wires[j][0]);
            }
            cnt = 0;
            visited = new boolean[n+1];
            dfs(1);
            answer = Math.min(answer,Math.abs(n-cnt-cnt));
        }
        return answer;
    }
    static void dfs(int v){
        visited[v]=true;
        cnt++;
        for(int i=0;i<map[v].size();i++){
            int tmp = map[v].get(i);
            if(!visited[tmp]){
                dfs(tmp);
            }
        }
    }
}