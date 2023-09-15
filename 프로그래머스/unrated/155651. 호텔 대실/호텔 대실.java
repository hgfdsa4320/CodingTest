import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
        Arrays.sort(book_time,(a,b)->changeTime(a[0])-changeTime(b[0]));
        pq.offer(changeTime(book_time[0][1])+10);
        int answer = 1;
      
        for(int i=1;i<book_time.length;i++){
            while(!pq.isEmpty() && pq.peek()<=changeTime(book_time[i][0])){
                pq.poll();
            }
            pq.offer(changeTime(book_time[i][1])+10);
            answer = Math.max(answer,pq.size());            
        }
        return answer;
    }
    static int changeTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        return hour*60+min;
    }
    
}