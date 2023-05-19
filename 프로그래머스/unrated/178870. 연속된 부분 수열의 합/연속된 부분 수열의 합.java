import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        ArrayList<int[]> list = new ArrayList<>(); // {길이,시작 인덱스, 끝 인덱스}
        int start = 0;
        int end = 0;
        int sum = sequence[start];
        
        while(end<sequence.length){
            if(sum==k){
                list.add(new int[]{end-start,start,end});
                if(end==sequence.length-1) break;
                sum-=sequence[start++];
                sum+=sequence[++end];
            }else if(sum<k){
                if(end==sequence.length-1) break;
                sum+=sequence[++end];      
            }else{
                sum-=sequence[start++];
            }
        }
        Collections.sort(list,(a,b)->(a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);
        int[] answer = {list.get(0)[1],list.get(0)[2]};
        return answer;
    }
}