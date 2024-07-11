/**
bfs
**/
import java.util.*;

class Solution {
    static int max = 0;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        q.offer(new int[]{1,0});
        visited[1] = true;
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int now = tmp[0];
            int cnt = tmp[1];
            max = Math.max(max,cnt);
            dist[now] = cnt;
            for(int i=0;i<list[now].size();i++){
                int next = list[now].get(i);
                if(!visited[next]){
                    q.offer(new int[]{next,cnt+1});
                    visited[next] = true;
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(dist[i] == max) answer++;
        }
        return answer;
    }
}