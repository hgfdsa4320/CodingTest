import java.util.*;
class Solution {
    public int[] solution(String s) {
        int time = 0;
        int cnt = 0;
        while(true){
            if(s.equals("1")) break;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    sb.append('1');
                }
            }
            cnt+=s.length()-sb.length();
            s = Integer.toString(sb.length(),2)+"";
            time++;
        }
        return new int[]{time,cnt};
    }
}

