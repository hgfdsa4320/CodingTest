import java.util.*;

class Solution {
    static int answer;
    static int len;
    static String[] nums;
    static boolean[] visited;
    static Set<Integer> set;
    public int solution(String numbers) {

        nums = numbers.split("");
        len = numbers.length();
        visited = new boolean[len];
        set = new HashSet<>();
        dfs("");
        return set.size();
    }
    static void dfs(String num){
        if(num.length()>0 && findNum(num)){
            set.add(Integer.parseInt(num));
        }
        if(num.length()<len){
            for(int i=0;i<nums.length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    dfs(num+nums[i]);
                    visited[i]=false;
                }
                    
            }
            
        }
    }
    
    static boolean findNum(String num){
        int n = Integer.parseInt(num);
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}