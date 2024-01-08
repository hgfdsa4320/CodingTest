import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int len = m.length();
        PriorityQueue<String[]> pq = 
            new PriorityQueue<>((a,b)->(changeTime(b[1])-changeTime(b[0]))-(changeTime(a[1])-changeTime(a[0])));
        for(String musicinfo : musicinfos){
            String[] tmp = musicinfo.split(",");
            pq.offer(tmp);
        }
        while(!pq.isEmpty()){
            String[] tmp = pq.poll();
            String s = tmp[3];
            int time = changeTime(tmp[1])-changeTime(tmp[0]);
            m = m.replace("C#","q").replace("D#","w").replace("F#","e").replace("G#","r").replace("A#","t");
            s = s.replace("C#","q").replace("D#","w").replace("F#","e").replace("G#","r").replace("A#","t");
            while(s.length()<time){
                s = s+s;
            }
            s = s.substring(0,time);
            
            if(s.contains(m)){
                answer = tmp[2];
                break;
            }
        }
        
        if(answer.equals("")){
            return "(None)";
        }
        return answer;
    }
    
    static int changeTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        return hour*60+min;
    }
}