import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int work : works){
            pq.offer(work);
        }
        long answer = 0;
        while(!pq.isEmpty() && n>0){
            n--;
            int tmp = pq.poll();
            if(tmp>1){
                pq.offer(tmp-1);
            }
        }
        while(!pq.isEmpty()){
            int tmp = pq.poll();
            answer+=(long)(Math.pow(tmp,2));
        }
        return answer;
    }
}