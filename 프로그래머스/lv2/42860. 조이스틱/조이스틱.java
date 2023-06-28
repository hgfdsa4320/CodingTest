import java.util.*;

class Solution {
    static String target;
    static int answer;
    static int[] alpha;
    public int solution(String name) {
        answer = Integer.MAX_VALUE;
        target = name;
        alpha = new int[26]; //A에서 해당 알파벳으로 만들기 위한 횟수
        for(int i=0;i<26;i++){
            alpha[i] = Math.min(i,26-i);
        }
        bfs();        
        return (answer<=0)?0:answer-1;
    }
    static void bfs(){
        //{횟수, index,현재 이름,방향}, 횟수를 오름차순으로 정렬
        PriorityQueue<String[]> pq = new PriorityQueue<>((a,b)->Integer.parseInt(a[0])-Integer.parseInt(b[0]));
        
        String name = ""; //초기값 A로 채워줌
        for (int i = 0; i < target.length(); i++) {
            name += "A";
        }
        // 초기값
        pq.offer(new String[]{"0","0",name,"next"});
        pq.offer(new String[]{"0","0",name,"previous"});
        while(!pq.isEmpty()){
            String[] tmp = pq.poll();
            int cnt = Integer.parseInt(tmp[0]);
            int idx = Integer.parseInt(tmp[1]);
            name = tmp[2];
            String direction = tmp[3];
            boolean isChange = false; // idx번째 문자에 변화가 있냐
            if(name.equals(target)){
                answer = cnt;
                break;
            }
            else{
                int change = alpha[target.charAt(idx)-name.charAt(idx)];
                if(change!=0){
                    isChange = true;
                    cnt+=change;
                }
                
                int nextIdx = (idx==target.length()-1)?0:idx+1;
                int previousIdx = (idx==0)?target.length()-1:idx-1;
                if(idx!=target.length()-1){
                    name = name.substring(0,idx)+String.valueOf(target.charAt(idx))+name.substring(idx+1);
                }else{
                    name = name.substring(0,idx)+String.valueOf(target.charAt(idx));
                }
                if(isChange){
                    pq.offer(new String[]{String.valueOf(cnt+1),String.valueOf(nextIdx),name,"next"});
                    pq.offer(new String[]{String.valueOf(cnt+1),String.valueOf(previousIdx),name,"previous"});    
                }else if(direction.equals("next")){
                    pq.offer(new String[]{String.valueOf(cnt+1),String.valueOf(nextIdx),name,"next"});
                }else{
                    pq.offer(new String[]{String.valueOf(cnt+1),String.valueOf(previousIdx),name,"previous"});    
                }
                
            }
            
        }
    }
}