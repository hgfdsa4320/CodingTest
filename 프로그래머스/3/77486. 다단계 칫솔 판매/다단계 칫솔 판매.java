import java.util.*;

class Solution {
    // 이전 사람 이름 알려주는 맵
    static Map<String, String> prevPersonMap;
    // 현재 사람의 배열 위치 알려주는 맵
    static Map<String, Integer> personMap;
    static int[] answer;
    
    
    static void findAmount(String name, int price){
        if(prevPersonMap.containsKey(name) && price/10 >=1){
            int idx = personMap.get(name);
            answer[idx]+=price-(price/10);
            findAmount(prevPersonMap.get(name),price/10);
        }else{
            int idx = personMap.get(name);
            answer[idx]+=price-price/10;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        prevPersonMap = new HashMap<>();
        personMap = new HashMap<>();
        answer = new int[enroll.length];
        
        for(int i=0;i<referral.length;i++){
            personMap.put(enroll[i],i);
        
            if(!referral[i].equals("-")){
                prevPersonMap.put(enroll[i],referral[i]);
            }
        }
        for(int i=0;i<seller.length;i++){
            findAmount(seller[i],100*amount[i]);
        }
        
        return answer;
    }
}