class Solution {
    public long solution(int r1, int r2) {
        long answer=0;
        long small = (long)Math.pow(r1,2);
        long big = (long)Math.pow(r2,2);
        
        for(int i=0;i<=r2;i++){
            //tmpBig은 x좌표가 i일 때, y값을 나타냄
            int tmpBig = (int)Math.sqrt(big-(long)Math.pow(i,2));
            int tmpSmall = (int)Math.sqrt(small-(long)Math.pow(i,2));
            //딱 나눠 떨어지는 수라면 1더함 ex) tmpBig==2이고 tmpSmall이 0일 경우
            if(Math.pow(tmpSmall,2)==small-(long)Math.pow(i,2) || tmpSmall==0) answer++;
            answer+=tmpBig-tmpSmall;
        }
        answer-=r2-r1+1; //현재 양수 x,y축이 더해졌으므로 하나 빼줌
        return answer*4;
    }
}

