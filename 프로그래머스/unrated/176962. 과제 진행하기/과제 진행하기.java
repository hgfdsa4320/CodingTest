import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int t = 0;//현재 시간
        int idx = 0; 
        //{name, start, playtime}, 시작시간을 기준 오름차순 정렬
        PriorityQueue<String[]> pq = new PriorityQueue<>((a,b)->Integer.parseInt(a[1])-Integer.parseInt(b[1]));
        for(String[] plan : plans){
            pq.offer(new String[]{plan[0],changeTime(plan[1]),plan[2]});
        }
        Stack<String[]> st = new Stack<>(); // 남은 과제를 넣는 스택
        while(!pq.isEmpty()){
            // 잠시 멈춘 과제가 있고 과제를 새로 시작하는 시간이 안되었을 때
            while(!st.isEmpty() && t<Integer.parseInt(pq.peek()[1])){ 
                String[] tmp = st.pop();
                int playtime = Integer.parseInt(tmp[2]);
                int nextStart = Integer.parseInt(pq.peek()[1]); //다음 과제 시작 시간
                if(nextStart<t+playtime){
                    st.push(new String[]{tmp[0],tmp[1],String.valueOf(playtime-(nextStart-t))});
                    t = nextStart;
                }else{
                    answer[idx++] = tmp[0];
                    t += playtime;
                }
                
            }
            String[] tmp = pq.poll();
            t = Integer.parseInt(tmp[1]); 
            int playtime = Integer.parseInt(tmp[2]);
            if(!pq.isEmpty()){
                int nextStart = Integer.parseInt(pq.peek()[1]); //다음 과제 시작 시간
                if(nextStart<t+playtime){
                    st.push(new String[]{tmp[0],tmp[1],String.valueOf(playtime-(nextStart-t))});
                    t = nextStart;
                }else{
                    answer[idx++] = tmp[0];
                    t+=playtime;
                }
            }else{
                answer[idx++] = tmp[0];
                t+=playtime;
            }

        }
        while(!st.isEmpty()){
            answer[idx++] = st.pop()[0];
        }
        return answer;
    }
    static String changeTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return String.valueOf(hour*60+minute);
    }
}