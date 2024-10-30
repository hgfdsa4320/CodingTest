import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> fruitMap = new HashMap<>();
        int answer = 0;
        for(int i=0;i<want.length;i++){
            fruitMap.put(want[i],number[i]);
        }
        int cnt = want.length;
        
        for(int i=0;i<10;i++){
            String fruit = discount[i];
            if(!fruitMap.containsKey(fruit)){
                continue;
            }
            fruitMap.put(fruit,fruitMap.get(fruit)-1);
            if(fruitMap.get(fruit)==0){
                cnt--;
            }
        }
        if(cnt==0) answer++;
        int start = 0;
        for(int i=10;i<discount.length;i++){
            //할인이 끝난 과일
            String fruit = discount[start++];
            if(fruitMap.containsKey(fruit)){
                fruitMap.put(fruit,fruitMap.get(fruit)+1);    
                // 이제 원하는 개수만큼 할인이 안될 경우
                if(fruitMap.get(fruit)==1){
                    cnt++;
                }
            }
            // 할인하는 과일
            fruit = discount[i];
            if(fruitMap.containsKey(fruit)){
                fruitMap.put(fruit,fruitMap.get(fruit)-1);
                if(fruitMap.get(fruit)==0){
                    cnt--;
                }    
            }
            
            if(cnt==0) answer++;
        }
        return answer;
    }
}