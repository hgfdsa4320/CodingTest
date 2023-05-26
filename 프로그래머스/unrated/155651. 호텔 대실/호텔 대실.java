import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int n = book_time.length;
         int[][] times = new int[n][2];
        for(int i=0;i<n;i++){
            times[i][0] = changeTime(book_time[i][0]);
            times[i][1] = changeTime(book_time[i][1]);
        }
        Arrays.sort(times,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 대실 종료 시간+10분
        int t = 0;
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && pq.peek()<=times[i][0]){
                pq.poll();
            }
            pq.offer(times[i][1]+10);
            answer = Math.max(answer,pq.size());
        }
        return answer;
    }
    static int changeTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h*60+m;
    }
}