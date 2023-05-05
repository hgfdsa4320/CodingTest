import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length]; 
        Arrays.fill(answer,-1);
        Stack<int[]> stack = new Stack<>(); //{index, 값}
        stack.push(new int[]{0,numbers[0]});
        for(int i=1;i<numbers.length;i++){
            while(!stack.isEmpty() && stack.peek()[1]<numbers[i]){
                int[] tmp = stack.pop();
                answer[tmp[0]] = numbers[i]; 
            }
            stack.push(new int[]{i,numbers[i]});
        }
        return answer;
    }
}