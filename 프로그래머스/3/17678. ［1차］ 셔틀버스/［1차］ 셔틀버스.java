import java.util.*;

class Solution {
    static int changeMin(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
    }
    
    static String changeToHour(int time){
        String h = time/60+"";
        String m = time%60+"";
        if(h.length()==1){
            h ="0"+h;
        }
        if(m.length()==1){
            m="0"+m;
        }
        return h+":"+m;
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        // String answer = "";
        PriorityQueue<Integer> timePQ = new PriorityQueue<>();
        for(int i=0;i<timetable.length;i++){
            timePQ.offer(changeMin(timetable[i]));
        }
        int time = 9*60; // 9시 시작
        int last = 0;
        int num=0;
        for(int i=0;i<n;i++){
            num = m;
            while(!timePQ.isEmpty()){
                if(time>=timePQ.peek()){
                    last = timePQ.poll();
                    num--;
                    if(num==0) break;
                }else{
                    break;
                }
            }
            time+=t;
        }
        time-=t;
        
        int answer = 0;
        if(num==0){
            answer = last-1;
        }else{
            answer = time;   
        }
        
        return changeToHour(answer);
    }
}