import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        boolean[] alpha = new boolean[26];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<skip.length();i++){
            set.add(skip.charAt(i)-'a');
        }
        for(int i=0;i<s.length();i++){
            int cnt = index;
            int now = s.charAt(i)-'a';
            now = now==alpha.length-1? 0 : now+1;
            while(cnt>0){
                if(!set.contains(now)){
                    cnt--;
                    if(cnt==0){
                        
                        answer+=(char)('a'+now);
                    }
                }
                now = now==alpha.length-1? 0 : now+1;
            }
            
        }
        return answer;
    }
}