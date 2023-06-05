import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Integer,Integer> map = new HashMap<>();
        long answer = 0;
        int n = weights.length;
        Set<Integer> set = new HashSet<>();
        for(int weight : weights){
            map.put(weight,map.getOrDefault(weight,0)+1);
            set.add(weight);
        }
        for(Integer i : set){
            long tmp = map.get(i); // i의 개수
            if(tmp>1){
                answer+=(tmp*(tmp-1))/2;
            }
            if(i%2==0 && set.contains(i/2*3)){
                answer+=tmp*map.get(i/2*3);
            }
            if(i%3==0 && set.contains(i*4/3)){
                answer+=tmp*map.get(i*4/3);
            }
            if(set.contains(i*2)){
                answer+=tmp*map.get(i*2);
            }
        }
        
        
        return answer;
    }
}