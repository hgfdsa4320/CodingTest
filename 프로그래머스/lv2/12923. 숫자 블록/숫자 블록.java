import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end-begin)+1];
        int idx = 0;
        for(long i=begin;i<=end;i++){
            answer[idx++] = findNum(i);
        }
        return answer;
    }
    
    static int findNum(long n){
        if(n==1) return 0;
        //소수가 아닐때 몫이 10000000이상일때 넣어두기 위한 리스트
        List<Integer> list = new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                 if((int)(n/i)<=10000000){
                     return (int)(n/i);     
                 }else{
                     list.add(i);
                 }
                
            }
        }
        if(list.size()>0){
            Collections.sort(list,Collections.reverseOrder());
            return list.get(0);
        }
        
        return 1;
    }
}