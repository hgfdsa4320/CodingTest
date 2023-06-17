import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        boolean[] checked = new boolean[relation[0].length]; 
        int answer = 0;
         
        for(int i=1;i<=relation[0].length;i++){ // 칼럼 수
            List<Integer> list = new ArrayList<>(); // 현재 후보키가 될 수 있을 지 검사할 칼럼들
            int idx=0;
            // 후보키가 될 칼럼들을 선택 하는 반복문 ex) i가 2이면 칼럼 두개를 찾는과정->이름,전공
            while(idx<relation[0].length && list.size() < i){ 
                if(!checked[idx]){
                    list.add(idx);
                }
                idx++;
            }
            if(list.size()<i) continue;
            boolean isPossible = true;
            Loop:
            for(int j=0;j<relation.length;j++){
                Set<String> set = new HashSet<>();
                for(int k=0;k<list.size();k++){
                    if(set.contains(relation[j][list.get(k)])){
                        isPossible = false;
                        break Loop;
                    }
                    set.add(relation[j][list.get(k)]);
                }
            }
            
            if(isPossible) {
                answer++;
                for(int k=0;k<list.size();k++){
                    checked[list.get(k)]=true;
                }
            }
        }
        return answer;
    }
}