import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer =new int[2];
        while(!s.equals("1")){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0') answer[1]++;
            }
            s = s.replace("0","");
            int n = s.length();
           
            s = Integer.toString(n,2);
            System.out.println(n+" "+s);
            answer[0]++;
        }
        
        
        return answer;
    }
}

