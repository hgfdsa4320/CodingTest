/**
다익스트라 알고리즘
**/
import java.util.*;

class Solution {
    static int answer;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<int[]>[] list;
    public int solution(int N, int[][] road, int K) {
        answer = 0;
        dist = new int[N+1];
        visited = new boolean[N+1];        
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }
        dijkstra(1);
        for(int i=1;i<=N;i++){
            if(dist[i]<=K) answer++;
        }
        return answer;
    }
    static void dijkstra(int v){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{v,0});
        
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int x = p[0];
            int d = p[1]; 
            visited[x] = true;
            for(int i=0;i<list[x].size();i++){
                int[] next = list[x].get(i);
                if(!visited[next[0]] && d+next[1]<dist[next[0]]){
                    dist[next[0]] = d+next[1];
                    pq.offer(new int[]{next[0],dist[next[0]]});
                }
            }
        }
    }
}