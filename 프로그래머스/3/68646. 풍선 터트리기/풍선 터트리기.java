import java.util.*;

class Solution {
    public int solution(int[] a) {
        int[] minLeft = new int[a.length];
        int[] minRight = new int[a.length];
        int min = a[0];
        for(int i=0;i<a.length-1;i++){
            min = Math.min(min,a[i]);
            minLeft[i] = min;
        }
        
        min = Integer.MAX_VALUE;
        for(int i=a.length-1;i>0;i--){
            min = Math.min(min,a[i]);
            minRight[i] = min;
        }
        int answer = 2;
        for(int i=1;i<a.length-1;i++){
            if(a[i]>minLeft[i-1] && a[i]>minRight[i+1])
                continue;
            answer++;
        }
        return answer;
    }
}