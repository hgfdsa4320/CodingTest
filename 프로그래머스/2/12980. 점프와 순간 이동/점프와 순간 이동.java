import java.util.*;

public class Solution {
    static int answer = Integer.MAX_VALUE;
    static void find(int n,int cnt){
        if(n==1){
            answer = Math.min(answer,cnt);
            return;
        }
        if(n%2==0)
            find(n/2,cnt);
        else
            find(n-1,cnt+1);
    }
    public int solution(int n) {
        find(n,0);
        return answer+1;
    }
}
