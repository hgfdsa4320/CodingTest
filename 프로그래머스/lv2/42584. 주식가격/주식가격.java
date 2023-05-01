import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]); //{index,가격} 가격을 기준으로 내림차순 정렬
        pq.offer(new int[]{0,prices[0]});
        
        for(int i=1;i<prices.length;i++){
            while(!pq.isEmpty()){
                if(pq.peek()[1]>prices[i]){ // pq에서 가장 높은 가격이 현재가격보다 높다면(가격이 떨어졌다면)
                    int[] tmp = pq.poll();
                    answer[tmp[0]] = i-tmp[0];
                }else{
                    break;
                }
            }
            pq.offer(new int[]{i,prices[i]});
        }
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            answer[tmp[0]] = prices.length-1-tmp[0];
        }
        
        return answer;
    }
}