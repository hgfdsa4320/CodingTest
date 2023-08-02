import java.util.*;

class Solution {
    public String solution(String X, String Y) {
    
        Map<Character,Integer> mapX = new HashMap<>();
        Map<Character,Integer> mapY = new HashMap<>();
        for(int i=0;i<X.length();i++){
            mapX.put(X.charAt(i),mapX.getOrDefault(X.charAt(i),0)+1);
        }
        for(int i=0;i<Y.length();i++){
            mapY.put(Y.charAt(i),mapY.getOrDefault(Y.charAt(i),0)+1);
        }
        char[] nums = {'0','1','2','3','4','5','6','7','8','9'};
      
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<nums.length;i++){
            int cnt = Math.min(mapX.getOrDefault(nums[i],0),mapY.getOrDefault(nums[i],0));
            if(cnt!=Integer.MAX_VALUE){
                for(int j=0;j<cnt;j++){
                    sb.append(nums[i]);
                }    
            }
            
        }
        String answer = sb.reverse().toString();
        if(answer.equals("")){
            return "-1";    
        }else if(answer.charAt(0)=='0'){
            return "0";
        }else{
            return answer;    
        }
        
    }
}