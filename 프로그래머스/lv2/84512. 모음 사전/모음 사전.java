class Solution {
    static String target;
    static int answer;
    static String[] words;
    static int cnt;
    public int solution(String word) {
        answer = 0;
        target = word;
        words = new String[]{"A","E","I","O","U"};
        cnt=0;
        dfs("");

        return answer;
    }
    static void dfs(String word){
        if(word.equals(target)){
            answer = cnt;
            return;
        }else if(word.length()<5){
            for(int i=0;i<5;i++){
                cnt++;
                dfs(word+words[i]);
            }
        }
    }
}