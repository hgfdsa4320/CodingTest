class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] area = new boolean[n+1];
        for(int s : section){
            area[s] = true;
        }
        for(int i=1;i<=n;i++){
            if(area[i]){
                for(int j=0;j<m;j++){
                    if(i+j<=n){
                        area[i+j] = false;
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}