class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int[][] fromTo = new int[friends.length][friends.length];
        int[][] giftNums = new int[friends.length][2]; //준 선물 수,받은 선물 수
        for(String gift : gifts){
            String from = gift.split(" ")[0];
            String to = gift.split(" ")[1];
            int f = 0;
            int t = 0;
            for(int i=0;i<friends.length;i++){
                if(friends[i].equals(from)){
                    f = i;
                }
                if(friends[i].equals(to)){
                    t = i;
                }
            }
            fromTo[f][t]++;
            giftNums[f][0]++;
            giftNums[t][1]++;
        }
        for(int i=0;i<giftNums.length;i++){
            int cnt = 0;
            for(int j=0;j<giftNums.length;j++){
                if(fromTo[i][j]==fromTo[j][i]){
                    if(giftNums[i][0]-giftNums[i][1]>giftNums[j][0]-giftNums[j][1]){
                        cnt++;
                    }
                }else{
                    if(fromTo[i][j]>fromTo[j][i]){
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer,cnt);
        }
        
        return answer;
    }
}