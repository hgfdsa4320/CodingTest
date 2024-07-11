/**
1<=n<=100
union find
우선순위큐 만들고(건설 비용이 적은 순으로)
하나씩 빼서 연결되있나 확인하고 연결

**/

import java.util.*;

class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        for(int i=0;i<costs.length;i++){
            pq.offer(new int[]{costs[i][0],costs[i][1],costs[i][2]});
        }
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int a = p[0];
            int b = p[1];
            if(union(a,b)){ // 원래 연결되어있지 않았다면
                int cost = p[2];
                answer+=cost;
            }
            
        }
        return answer;
    }
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) {
            return false;
        } else if(a<b){
            parent[b] = a;
        } else{
            parent[a] = b;  
        }
        return true;
    }
    
    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}