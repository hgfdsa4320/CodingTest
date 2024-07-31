/**
순열로 순서 정의 -> 해당 순위로 계산
계산하는 함수 하나 -> int calculate(String expression) 
리스트에 숫자 넣고

**/
import java.util.*;

class Solution {
    static int[] arr = new int[3];
    static boolean[] visited = new boolean[3];
    static long answer;
    static Map<Integer,Character> map = new HashMap<>();
    public long solution(String expression) {
        answer = 0;
        map.put(0,'+');
        map.put(1,'-');
        map.put(2,'*');
        findNum(0,expression);
        return answer;
    }
    static void findNum(int cnt, String expression){
        if(cnt==3){
            long value = calculate(expression);
            answer = Math.max(answer,value);
            return;
        }
        for(int i=0;i<3;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = i;
                findNum(cnt+1,expression);
                visited[i] = false;
                
            }
        }
    }
   
        
    static long calculate(String expression){
        List<Long> nums = new ArrayList<>();
        List<Character> oper = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(!Character.isDigit(c)){
                oper.add(c);
            }else{
                long tmp = c-'0';
                i++;
                while(i<expression.length() && Character.isDigit(expression.charAt(i))){
                    tmp = tmp*10+(expression.charAt(i)-'0');
                    i++;
                }
                i--;
                nums.add(tmp);
            }
        }
        for(int i=0;i<3;i++){
            char now = map.get(arr[i]);
            long prev = nums.get(0);
            List<Long> tmpNums = new ArrayList<>();
            List<Character> tmpOper = new ArrayList<>();
            boolean isOkay = false;
            tmpNums.add(nums.get(0));
            for(int j=0;j<oper.size();j++){
                char c = oper.get(j);
                if(c==now){
                    long tmp = tmpNums.get(tmpNums.size()-1);
                    tmpNums.remove(tmpNums.size()-1);
                    if(c=='+'){
                        tmp = tmp+nums.get(j+1);
                    }else if(c=='-'){
                        tmp = tmp-nums.get(j+1);
                    }else{
                        tmp = tmp*nums.get(j+1);
                    }
                    tmpNums.add(tmp);
                }else{
                    long tmp = nums.get(j+1);
                    tmpNums.add(tmp);
                    tmpOper.add(c);
                }
            }
            nums = tmpNums;
            oper = tmpOper;
            
        }
        return Math.abs(nums.get(0));
    }
}
