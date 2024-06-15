import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        // 첫번째랑 끝에는 같이 나올 수 없으므로 두 개를 나눠 최댓값을 각각 구하고 둘 중 큰 값 리턴
        int[][] a = new int[sticker.length][2];
        int[][] b = new int[sticker.length][2];
        
        //끝 값 제외
        for(int i=0;i<sticker.length-1;i++){
            a[i+1][0] = Math.max(a[i][0],a[i][1]);
            a[i+1][1] = a[i][0]+sticker[i];
        }
        
        //첫 값 제외
        for(int i=1;i<sticker.length;i++){
            b[i][0] = Math.max(b[i-1][0],b[i-1][1]);
            b[i][1] = b[i-1][0]+sticker[i];
        }        
        answer = Math.max(Math.max(a[a.length-1][0],a[a.length-1][1]),Math.max(b[b.length-1][0],b[b.length-1][1]));
        if(sticker.length==1)
            answer=sticker[0];
        return answer;
    }
}

