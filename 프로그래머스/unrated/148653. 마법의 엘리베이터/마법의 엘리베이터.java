import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int n = String.valueOf(storey).length();
        //{마법의 돌 수, 현재 수}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,storey});
        while(true){
            int[] tmp = pq.poll();
            int cnt = tmp[0];
            int now = tmp[1];
            
            if(now == 0) {
                answer = cnt;
                break;
            }
            int temp = 1;
            while(now%10==0){
                temp*=10;
                now/=10;
            }
            pq.offer(new int[]{cnt+10-(now%10),(now/10+1)*temp*10}); //올림
            pq.offer(new int[]{cnt+(now%10),now/10*temp*10});
        }
        return answer;
    }
}