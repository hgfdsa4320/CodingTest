import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>(); // {나오는 시간, 무게}
        int t = 1;
        int idx = 0; // 트럭의 인덱스
        q.offer(new int[]{t+bridge_length,truck_weights[idx]}); // 첫 트럭 넣기
        weight-=truck_weights[idx];
        t++;
        idx++;
        
        while(idx<truck_weights.length){
            if(t==q.peek()[0]){
                int[] tmp = q.poll();
                weight += tmp[1];
            }
            if(weight>=truck_weights[idx]){
                q.offer(new int[]{t+bridge_length,truck_weights[idx]});
                weight -= truck_weights[idx];
                idx++;
            }
            else{
                t = q.peek()[0];
                continue;
            }
            t++;
        }
            
        while(!q.isEmpty()){
            answer = q.poll()[0];
        }
        return answer;
    }
}