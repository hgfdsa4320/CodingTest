import java.util.*;

class Solution {
    static boolean isOkay;
    
    static int findNum(int[] rocks, int n,int distance){
        int now = 0;
        int cnt = 0;
        for(int i=0;i<rocks.length;i++){
            int diff = rocks[i]-now;
            if(diff==n) isOkay = true;
            if(diff<n){
                cnt++;
            }else{
                now = rocks[i];
            }
        }
        if(distance-now<n){
            cnt++;
        }
        if(distance-now==n){
            isOkay = true;
        }
        return cnt;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = 1000000000;
        
        Arrays.sort(rocks);
        
        while(left<=right){
            int mid = (left+right)/2;
            isOkay = false;
            int num = findNum(rocks,mid,distance);
            if(num<=n){
                if(isOkay)
                    answer = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return answer;
    }
}