import java.util.*;

class Solution {
    static int[] arr = new int[11];
    static int[] answer;
    static int max = 1; // 점수 차
    static boolean isPossible;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        isPossible = false;
        dfs(0,0,n,info);
        if(!isPossible) return new int[]{-1};
        return answer;
    }
    static void dfs(int depth, int idx, int n, int[] info){
        
        int apeach = 0;
        int ryan = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>info[i]){
                ryan+=10-i;
            }else if(info[i]!=0){
                apeach+=10-i;
            }
        }
        int tmp = ryan-apeach;
        // 원래 점수차보다 크거나, 같은 경우 가장 낮은 점수를 더 맞혔다면   
        if(tmp>max || (tmp==max && confirmScore(answer,arr))){
            max = tmp;
            isPossible = true;
            answer = Arrays.copyOf(arr,arr.length);
            answer[10] = n-depth; //만약 화살을 전부 쏘지 않았을 경우 0점으로 간주
        }
        if(depth<n){
            for(int i=idx;i<arr.length;i++){
                if(info[i]>=arr[i]){
                    int sub = info[i]-arr[i]+1;
                    if(depth+sub<=n){
                        arr[i]+=sub;
                        dfs(depth+sub,i+1,n,info);
                        arr[i]-=sub;    
                    }
                }
            }
        }    
        
    }
    
    // 새 배열이 가장 낮은 점수를 더 많이 맞혔다면 true 반환
   static boolean confirmScore(int[] answer, int[] arr){
       for(int i=10;i>=0;i--){
           if(arr[i]>answer[i]){
               return true;
           }else if(arr[i]<answer[i]){
               return false;
           }
       }
       return true;
   }
}