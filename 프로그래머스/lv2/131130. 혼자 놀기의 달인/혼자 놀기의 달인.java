import java.util.*;

class Solution {
    static boolean[] checked;
    static int cnt;
    public int solution(int[] cards) {
        
        checked = new boolean[cards.length+1]; // 번호 확인했는지 체크하는 배열
        List<Integer> list = new ArrayList<>(); // 각 장사그룹에 속한 상자의 수
        for(int i=1;i<=cards.length;i++){
            if(checked[i]) continue;
            cnt = 0;
            list.add(checkCnt(cards,i));
        }
        Collections.sort(list,Collections.reverseOrder());
        if(list.size()==1) return 0;
        int answer = list.get(0)*list.get(1);
        
        return answer;
    }
    static int checkCnt(int[] cards,int n){        
        checked[n] = true;
        cnt++;
        
        if(!checked[cards[n-1]]){
            checkCnt(cards,cards[n-1]);
        }
        return cnt;
    }
}