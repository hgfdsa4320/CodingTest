import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer> st = new Stack<>();
        
        for(int move : moves){
            int i = 0;
            while(i<n){
                int now = board[i][move-1];
                if(now!=0){
                    if(!st.isEmpty() && st.peek()==now){
                        st.pop();
                        answer+=2;
                    }else{
                        st.push(now);    
                    }
                    board[i][move-1]=0;
                    break;
                }else{
                    i++;
                }
            }
        }
        return answer;
    }
}