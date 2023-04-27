import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s);
        }
        while(pq.size()>=2){
            if(pq.peek()>=K){
                return answer;
            }
            int a = pq.poll();
            int b = pq.poll();
            if(b==0){
                return -1;
            }
            int mix = a+(b*2);
            pq.offer(mix);
            answer++;
        }
        if(pq.peek()>=K) return answer;
        return -1;
    }
}