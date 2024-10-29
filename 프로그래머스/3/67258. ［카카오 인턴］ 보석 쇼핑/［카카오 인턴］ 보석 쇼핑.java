import java.util.*;

class Solution {
    static Map<String, Integer> gemMap;
    public int[] solution(String[] gems) {
        gemMap = new HashMap<>();
        int idx = 0;
        for(String gem : gems){
            if(!gemMap.containsKey(gem)){
                gemMap.put(gem,idx++);
            }
        }
        int[] gemNow = new int[gemMap.size()];
        int cnt = gemMap.size();
        int start = 0;
        int end;
        List<int[]> list = new ArrayList<>();
        for(end=0;end<gems.length;end++){
            int gemIdx = gemMap.get(gems[end]);
            gemNow[gemIdx]++;
            if(gemNow[gemIdx]==1){
                cnt--;
            }
            while(start<end && gemNow[gemMap.get(gems[start])]>1){
                gemNow[gemMap.get(gems[start])]--;
                start++;
            }
            if(cnt==0){
                list.add(new int[]{start,end});
            }
            
        }
        Collections.sort(list,(a,b)->(a[1]-a[0])-(b[1]-b[0]));
        return new int[]{list.get(0)[0]+1,list.get(0)[1]+1};
    }
}