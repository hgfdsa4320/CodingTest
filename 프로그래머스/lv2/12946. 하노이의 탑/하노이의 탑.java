import java.util.*;
class Solution {
    static List<int[]> res;
    public int[][] solution(int n) {
        res = new ArrayList<>();
        hanoi(n,1,3,2);
        int[][] answer = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            answer[i][0] = res.get(i)[0];
            answer[i][1] = res.get(i)[1];
        }
        return answer;
    }
    static void hanoi(int n,int start, int end, int tmp){
        if(n==1){
            res.add(new int[]{start,end});
        }else{
            hanoi(n-1,start,tmp,end);
            res.add(new int[]{start,end});
            hanoi(n-1,tmp,end,start);
        }
    }
}