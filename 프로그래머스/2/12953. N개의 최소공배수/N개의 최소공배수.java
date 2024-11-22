import java.util.*;

class Solution {
    static int findLcd(int a,int b){
        if(a==0) return b;
        return findLcd(b%a,a);
    }
    public int solution(int[] arr) {
        int now = arr[0];
        for(int i=1;i<arr.length;i++){
            now = now*arr[i]/findLcd(now,arr[i]);
        }
        return now;
    }
}