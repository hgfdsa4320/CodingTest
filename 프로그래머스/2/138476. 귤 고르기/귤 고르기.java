import java.util.*;

class Gule{
    int size;
    int cnt;
    
    public Gule(int size,int cnt){
        this.size = size;
        this.cnt = cnt;
    }
}
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>(); 
        PriorityQueue<Gule> pq = new PriorityQueue<>((a,b)->b.cnt-a.cnt);
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        
        for(Integer size : map.keySet()){
            pq.offer(new Gule(size,map.get(size)));
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            Gule g = pq.poll();
            cnt++;
            k-=g.cnt;
            if(k<=0)
                break;
        }
        
        return cnt;
    }
}