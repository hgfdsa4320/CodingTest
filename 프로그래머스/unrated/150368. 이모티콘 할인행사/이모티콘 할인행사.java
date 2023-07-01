import java.util.*;
class Solution {
    static int[] discount ={10,20,30,40};
    static int n;
    static int[] answer;
    static List<int[]> list = new ArrayList<>(); // {가격, 할인율}
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        dfs(0,users,emoticons);
        return answer;
    }
    
    public static void dfs(int depth, int[][] users, int[] emoticons){
        if(depth == emoticons.length){
            int[] tmp = new int[2];
            for(int i=0;i<users.length;i++){
                boolean service = false; 
                int price=0;
                for(int j=0;j<list.size();j++){
                    if(list.get(j)[1]>=users[i][0]){
                        price+=list.get(j)[0];
                        if(price>=users[i][1]){ //일정 금액 이상이면 서비스 가입
                            service = true;
                            break;
                        }
                    }
                }
                if(service){
                    tmp[0]++;
                }else{
                    tmp[1]+=price;
                }
                
            }
            if(tmp[0]>answer[0]){
                answer[0] = tmp[0];
                answer[1] = tmp[1];
            }else if(tmp[0]==answer[0] && tmp[1]>answer[1]){
                answer[1] = tmp[1];
            }
            return;
        }
        for(int i=0;i<discount.length;i++){
            list.add(new int[]{emoticons[depth]*(100-discount[i])/100,discount[i]});
            dfs(depth+1,users,emoticons);
            list.remove(list.size()-1);
        }
    }
    
}