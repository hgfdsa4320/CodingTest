import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx=0;
        Stack<Integer> stack = new Stack<>();
        int i=1;
        while(i<=order.length){
            if(order[idx]==i){
                answer++;
                idx++;
                i++;
            }else if(!stack.isEmpty() && stack.peek()==order[idx]){
                idx++;
                stack.pop();
                answer++;
            }else{
                stack.push(i++);
            }
        }
        while(!stack.isEmpty() && stack.pop()==order[idx++]){
            answer++;
        }
        return answer;
    }
}