import java.util.*;

class Solution {
    public int solution(long n, int k, int[] enemy) {
        if(k>=enemy.length){
            return enemy.length;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); //적의 수를 오름차순
        int idx=0;
        for(;idx<k;idx++){ 
            pq.offer(enemy[idx]);
            n-=enemy[idx];
        }
        while(n<0){
            n+=pq.poll();
            k--;
        }
        while(k>=0 && idx<enemy.length){
            pq.offer(enemy[idx]);
            n-=enemy[idx];
            idx++;
            if(n<0){
                n+=pq.poll();
                k--;
                if(k<0) idx--;
            }
        }

        int answer = idx;
        return answer;
    }
    
}