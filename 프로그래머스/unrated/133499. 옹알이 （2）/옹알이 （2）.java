class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        for(String tmp : babbling){
            int prev = -1;
            int cnt = 0;
            Loop1:
            while(cnt<4){
                for(int i=0;i<words.length;i++){
                    if(tmp.indexOf(words[i])==0){
                        
                        if(prev == i){
                            break Loop1;
                        }
                        if(tmp.equals(words[i])){
                            answer++;
                            break Loop1;
                        }
                        prev = i;
                        tmp = tmp.substring(words[i].length(),tmp.length());
                        cnt = 0;
                    }else{
                        cnt++;
                    }
                }
            }
            
        }
        return answer;
    }
}