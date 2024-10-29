import java.util.*;

class Solution {
    static List<Integer>[] idList;
    static boolean[] visited;
    static Set<Integer> set;
    static int M;
    
    static void findBanIdList(String[] user_id, String[] banned_id){
        for(int i=0;i<banned_id.length;i++){
            String bId = banned_id[i];
            for(int j=0;j<user_id.length;j++){
                String uId= user_id[j];
                boolean isPossible = true;
                if(bId.length()!=uId.length()){
                    isPossible = false;
                }else{
                    for(int k=0;k<bId.length();k++){
                        char a = bId.charAt(k);
                        char b = uId.charAt(k);
                        if(a!='*' && a!=b){
                            isPossible = false;
                            break;
                        }
                    }
                }
                if(isPossible){
                    idList[i].add(j);
                }
            }
        }
    }
    
    static void dfs(int num,int now){
        if(num==M){
            String s = now+"";
            String[] tmp = s.split("");
            Arrays.sort(tmp);
            s = "";
            for(int i=0;i<tmp.length;i++){
                s+=tmp[i];
            }
            set.add(Integer.parseInt(s));
            return;
        }
        for(int i=0;i<idList[num].size();i++){
            int next = idList[num].get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(num+1,now*10+next);
                visited[next] = false;
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        idList = new ArrayList[banned_id.length];
        visited = new boolean[user_id.length];
        set = new HashSet<>();
        M = banned_id.length;
        
        for(int i=0;i<banned_id.length;i++){
            idList[i] = new ArrayList<>();
        }
        findBanIdList(user_id,banned_id);
        dfs(0,0);
        
        return set.size();
    }
}