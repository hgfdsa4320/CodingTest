import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data,(a,b)->(a[col-1]==b[col-1])?b[0]-a[0]:a[col-1]-b[col-1]);
        int[] arr = new int[row_end-row_begin+1];
        int idx = 0;
        for(int i=row_begin;i<=row_end;i++){
            for(int j=0;j<data[i-1].length;j++){
                arr[idx]+=data[i-1][j]%i;
            }
            idx++;
        }
        int answer = arr[0];
        for(int i=1;i<arr.length;i++){
            answer = findNum(answer,arr[i]);
        }
        return answer;
    }
    
    static int findNum(int prev, int now){
        String s1 = Integer.toString(prev,2);
        String s2 = Integer.toString(now,2);
        int cnt = Math.abs(s2.length()-s1.length());
        if(s1.length()<s2.length()){ // 길이가 맞지 않다면 앞에 0추가
            for(int i=0;i<cnt;i++){
                s1 = "0"+s1;
            }
        }else{
            for(int i=0;i<cnt;i++){
                s2 = "0"+s2;
            }
        }
        String s = "";
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                s+="1";
            }else{
                s+="0";
            } 
        }
        return Integer.parseInt(s,2);
    }
}