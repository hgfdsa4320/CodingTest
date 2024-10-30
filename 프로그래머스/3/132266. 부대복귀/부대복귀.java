import java.util.*;
class Input {
    int v;
    int cost;
    
    public Input(int v,int cost){
        this.v=v;
        this.cost=cost;
    }
}
class Solution {
    static int[] dist;
    static List<Integer>[] roadList;
    
    static void dijkstra(int v, int n){
        PriorityQueue<Input> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        boolean[] visited = new boolean[n+1];
        pq.offer(new Input(v,0));
        dist[v] = 0;
        
        while(!pq.isEmpty()){
            Input p = pq.poll();
            v = p.v;
            int cost = p.cost;
            if(visited[v]) continue;
            visited[v] = true;
            for(int i=0;i<roadList[v].size();i++){
                int next = roadList[v].get(i);
                if(!visited[next]){
                    if(dist[next]==-1 || dist[next]>cost+1){
                        dist[next] = cost+1;
                        pq.offer(new Input(next,cost+1));
                    }
                }
            }
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        dist = new int[n+1];
        roadList = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            roadList[i] = new ArrayList<>();
        }
        Arrays.fill(dist,-1);
        
        for(int i=0;i<roads.length;i++){
            int a = roads[i][0];
            int b = roads[i][1];
            roadList[a].add(b);
            roadList[b].add(a);
        }
        dijkstra(destination,n);
        int[] answer = new int[sources.length];
        for(int i=0;i<sources.length;i++){
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
}