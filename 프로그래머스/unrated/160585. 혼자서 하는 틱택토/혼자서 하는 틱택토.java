class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int cntO = 0;
        int cntX = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='O'){
                    cntO++;
                }else if(board[i].charAt(j)=='X'){
                    cntX++;
                }
            }
        }
        int cnt = cntO-cntX;
        if(!(cnt==0 || cnt==1)){
            return 0;
        }
        if(findBingGo(board,'O')){
            if(cnt != 1 || findBingGo(board,'X'))
                return 0;
        }
        if(findBingGo(board,'X')){
            if(cnt!=0) 
                return 0;
        }
        return answer;
    }
    
    static boolean findBingGo(String[] board, char c){
        int cnt =0;
        for(int i=0;i<3;i++){ //가로 빙고
            cnt = 0;
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)==c){
                    cnt++;
                }
            }
            if(cnt==3){
                return true;
            }
        }
        for(int j=0;j<3;j++){ // 세로 빙고
            cnt = 0;
            for(int i=0;i<3;i++){
                if(board[i].charAt(j)==c){
                    cnt++;
                }
            }
            if(cnt==3){
                return true;
            }
        }
        cnt=0;
        for(int i=0;i<3;i++){ // 대각선 빙고
            if(board[i].charAt(i)==c){
                cnt++;
            }
        }
        if(cnt==3){
            return true;
        }
        cnt=0;
        for(int i=0;i<3;i++){ // 대각선 빙고
            if(board[i].charAt(2-i)==c){
                cnt++;
            }
        }
        if(cnt==3){
            return true;
        }
        
        return false;
    }
}