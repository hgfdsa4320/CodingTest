import java.util.*;

class Solution {
    static List<Integer>[] idList;
    static boolean[] visited;
    static Set<Integer> set;
    static int M;
    
    static boolean isMatch(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }else{
            for(int k=0;k<s1.length();k++){
                char a = s1.charAt(k);
                char b = s2.charAt(k);
                if(a!='*' && a!=b){
                    return false;
                }
            }
        }
        return true;
    }
    
    static void findBanIdList(String[] user_id, String[] banned_id){
        for(int i=0;i<banned_id.length;i++){
            for(int j=0;j<user_id.length;j++){
                if(isMatch(banned_id[i],user_id[j])){
                    idList[i].add(j);
                }
            }
        }
    }
    
    static void dfs(int num,int bitMask){
        if(num==M){
            set.add(bitMask);
            return;
        }
        for(int i=0;i<idList[num].size();i++){
            int next = idList[num].get(i);
            int bit = 1<<next;
            if((bitMask & bit) == 0){
                dfs(num+1,bitMask | bit);
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