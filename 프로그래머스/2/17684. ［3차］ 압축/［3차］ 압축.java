import java.util.*;

class Solution {
    static Map<String,Integer> pressMap;
    public int[] solution(String msg) {
        pressMap = new HashMap<>();
        int idx = 1;
        for(int i=0;i<26;i++){
            pressMap.put((char)('A'+i)+"",idx++);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<msg.length();i++){
            int j = i;
            String tmp = "";
            int now = 0;
            while(j<msg.length()){
                tmp+=msg.charAt(j);
                if(pressMap.containsKey(tmp)){
                    now = pressMap.get(tmp);
                    j++;        
                }else{
                    list.add(now);
                    pressMap.put(tmp,idx++);
                    break;    
                }
            }
            if(j==msg.length()){
                list.add(now);
                break;
            }
            i = j-1;
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}