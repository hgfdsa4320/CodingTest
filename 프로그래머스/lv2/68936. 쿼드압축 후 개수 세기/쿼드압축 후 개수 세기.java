class Solution {
    static int cntZero;
    static int cntOne;
    public int[] solution(int[][] arr) {
        cntZero=0;
        cntOne=0;        
        dfs(arr,0,0,arr.length);
        int[] answer = new int[]{cntZero,cntOne};
        return answer;
    }
    
    static boolean checkIsSameArr(int[][] arr,int x1,int y1, int cnt){
        int tmp = arr[x1][y1];
        for(int i=x1;i<x1+cnt;i++){
            for(int j=y1;j<y1+cnt;j++){
                if(arr[i][j]!=tmp)
                    return false;
            }
        }   
        return true;
    }
    
    static void dfs(int[][] arr,int x1,int y1,int cnt){
        if(cnt==1 || checkIsSameArr(arr,x1,y1,cnt)){
            if(arr[x1][y1]==0){
                cntZero++;
            } else{
                cntOne++;
            }
            return;
        }
        dfs(arr,x1,y1,cnt/2);
        dfs(arr,x1,y1+cnt/2,cnt/2);
        dfs(arr,x1+cnt/2,y1,cnt/2);
        dfs(arr,x1+cnt/2,y1+cnt/2,cnt/2);
    }
}