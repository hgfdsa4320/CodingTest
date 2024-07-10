import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        parent = new int[stones.length]; 
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }  
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        for(int i=0;i<stones.length;i++){
            pq.offer(new int[]{i,stones[i]});
        }
        int now = pq.peek()[1];
        boolean isOkay = false;
        while(true){
            int start = 0;
            while(pq.peek()[1]==now){
                int[] p = pq.poll();
                int idx = p[0];
                stones[idx] = 0;
                if(idx>0 && stones[idx-1]==0){
                    union(idx-1,idx);
                }
                if(idx+1<stones.length && stones[idx+1]==0){
                    union(idx,idx+1);
                }
                
                start = find(idx);
                
                if(start+k<=stones.length && find(start)==find(start+k-1)){
                    isOkay = true; 
                    answer = now;
                    
                    break;
                }
            }
            if(isOkay){
                break;
            }
            now = pq.peek()[1];
            
        }
        return answer;
    }
    static boolean union(int a,int b){
        a = find(a);
        b = find(b);
        if(a==b) return false;;
        parent[b] = a;
        return true;
    }
    
    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}

/**
20만개
우선순위 큐[인덱스, 값] -> 값이 작은 순, 같으면 인덱스가 작은 순

K : 1이상 20만 이하 

3	3
1 1 2 2 2 3 4 4 5 5 
1 1 1번
2 2 2 2 번
3 3번
우선 순위 큐 이거 다 -> logN 시간 복잡도를 가짐 -> 
현재 : 우선순위큐 peek();
while(true){ 최대 -> N번
    if(우선순위큐 - 현재==0) 다 빼기 -> logN* 빼는 횟수만큼
    
    여기서 배열 확인 -> 20만번 -> 이거를 다른 로직으로 바꿔야 될 거같은데 
    흠 유니온파인드 써야되나
    -> 유니온 파인드 
}
**/