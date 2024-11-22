import java.util.*;

class Solution {
    static int answer;
    static char[] w;
    static int cnt;
    static void findNum(String now, String word){
        if(now.equals(word))
            answer = cnt;
        if(now.length()<5){
            for(int i=0;i<5;i++){
                cnt++;
                findNum(now+w[i],word);
            }
        }
    }
    public int solution(String word) {
        answer = 0;
        cnt = 0;
        w = new char[]{'A','E','I','O','U'};
        findNum("",word);
        return answer;
    }
}