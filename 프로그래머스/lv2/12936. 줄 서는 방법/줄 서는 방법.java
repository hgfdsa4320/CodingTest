import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long[] factorial = new long[20];
        factorial[0] = 1;
        factorial[1] = 1;
        for(int i=2;i<20;i++){
            factorial[i] = factorial[i-1]*i;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) list.add(i);
        
        for(int i=0;i<n;i++){
            int cnt=0;
            while(k>factorial[n-1-i]){
                k-=factorial[n-1-i];
                cnt++;
            }   
            answer[i] = list.get(cnt);
            list.remove(cnt);
        }
        
        
        return answer;
    }
}