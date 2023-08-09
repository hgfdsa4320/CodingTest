import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        while(s.length()>1){
            answer++;
            int cnt1 = 1;
            int cnt2 = 0;
            char c = s.charAt(0);
            int idx = 0;
            for(int i=1;i<s.length();i++){
                if(s.charAt(i)==c){
                    cnt1++;
                }else{
                    cnt2++;
                }
                if(cnt1==cnt2){
                    idx = i;
                    break;
                }
                idx = i;
            }
            s = s.substring(idx+1);
            
        }
        if(s.length()==1) answer++;
        
        return answer;
    }
}
