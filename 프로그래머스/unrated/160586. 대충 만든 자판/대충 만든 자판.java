import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int idx = 0;
        for(String target : targets){
            int cnt = 0;
            Loop1:
            for(int i=0;i<target.length();i++){
                char c = target.charAt(i);
                
                int j =0;
                while(true){
                    for(int k=0;k<keymap.length;k++){
                        if(keymap[k].length()>j && keymap[k].charAt(j)==c){
                            cnt+=j+1;
                            continue Loop1;
                        }
                    }
                    j++;
                    if(j==100){
                        cnt = -1;
                        break Loop1;
                    }
                }
                    
            }
            answer[idx++] = cnt;
        }
        return answer;
    }
}
