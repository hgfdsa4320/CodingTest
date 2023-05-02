import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(s<n)
            return new int[]{-1};
        
        int rest = s%n;
        Arrays.fill(answer,s/n);
        for(int i=1;i<=rest;i++){
            answer[answer.length-i]++;
        }
        return answer;
    }
}