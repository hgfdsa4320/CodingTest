import java.util.*;

class Solution {
    static String[] w;
    static int answer;
    static int time;
    static void dfs(String now,String word){
        if(now.equals(word)){
            answer = time;
            return;
        } 
        if(now.length()<5){
            for(int i=0;i<5;i++){
                time++;
                dfs(now+w[i],word);
            }
        }
    }
    
    public int solution(String word) {
        answer = 0;
        time = 0;
        w = new String[]{"A","E","I","O","U"};
        dfs("",word);
        return answer;
    }
}