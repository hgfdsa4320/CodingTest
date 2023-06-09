import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        //{광물 5개 값의 합, 시작 인덱스, 끝 인덱스}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int cnt = 0; //곡괭이 개수
        for(int pick : picks) cnt+= pick;
        int tmp = 0;
        int start = 0;
        int i=1;
        
        //곡괭이가 캘 수 있는 미네랄이랑, 전체 미네랄 수 중에 작은 수까지
        for(;i<=Math.min(cnt*5,minerals.length);i++){
            if(minerals[i-1].equals("diamond")){
                tmp+=25;
            }else if(minerals[i-1].equals("iron")){
                tmp+=5;
            }else{
                tmp+=1;
            }
            if(i%5==0) {
                pq.add(new int[]{tmp,start,i-1});
                tmp = 0;
                start = i;
            }
        }
        pq.add(new int[]{tmp,start,i-2});    
        int gok = 0; //곡괭이 인덱스
        Loop1:
        while(!pq.isEmpty()){
            while(picks[gok]==0){ // 곡갱이 개수가 0이면 다음 곡괭이쓰고 전부 다 쓰면 종료
                gok++;
                if(gok==3) break Loop1;
            }
            int[] arr = pq.poll();
            int a = arr[1];
            int b = arr[2];
            
            for(int j=a;j<=b;j++){
                if(gok==1 && minerals[j].equals("diamond")){
                    answer+=5;
                }else if(gok==2 && minerals[j].equals("iron")){
                    answer+=5;
                }else if(gok==2 && minerals[j].equals("diamond")){
                    answer+=25;
                }else{
                    answer++;
                }
            }
            picks[gok]--;
        }
        
        return answer;
    }
}