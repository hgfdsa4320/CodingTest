import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        if(topping.length<2) return 0;
 
        //롤케이크 자른 조각들
        Map<Integer,Integer> map1 = new HashMap<>(); 
        Map<Integer,Integer> map2 = new HashMap<>();
        
        // 1:나머지로 첨에 자름
        map1.put(topping[0],1);
        for(int i=1;i<topping.length;i++){
            map2.put(topping[i],map2.getOrDefault(topping[i],0)+1);
        }
        int idx = 1;
        while(idx<topping.length){
            if(map1.size()==map2.size()){
                answer++;  
            }
            map1.put(topping[idx],map1.getOrDefault(topping[idx],0)+1);

            if(map2.get(topping[idx])==1){           
                map2.remove(topping[idx]);
            } else{
                map2.put(topping[idx],map2.get(topping[idx])-1);
            }
                
            
            idx++;
        }
        return answer;
    }
}