import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxX=Integer.MIN_VALUE;
        int maxY=Integer.MIN_VALUE;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<line.length-1;i++){
            int[] a = line[i];
            for(int j=i+1;j<line.length;j++){
                int[] b= line[j];
                if((long)a[0]*b[1]==(long)a[1]*b[0]){ // 두 직선은 평행 또는 일치
                    continue;
                }else{
                    //x구할때 나누어 떨어지는지 확인
                    if(((long)a[1]*b[2]-(long)a[2]*b[1])%((long)a[0]*b[1]-(long)a[1]*b[0])!=0){
                        continue;
                        //y 
                    }else if(((long)a[2]*b[0]-(long)a[0]*b[2])%((long)a[0]*b[1]-(long)a[1]*b[0])!=0){
                        continue;
                    }
                    int x = (int)(((long)a[1]*b[2]-(long)a[2]*b[1])/((long)a[0]*b[1]-(long)a[1]*b[0]));
                    int y = (int)(((long)a[2]*b[0]-(long)a[0]*b[2])/((long)a[0]*b[1]-(long)a[1]*b[0]));

                    list.add(new int[]{x,y});
                    if(x>maxX){
                        maxX = x;
                    }
                    if(x<minX){
                        minX = x;
                    }
                    if(y>maxY){
                        maxY = y;
                    }
                    if(y<minY){
                        minY = y;
                    }
                    
                }
            }
        }
        String[] answer = new String[maxY-minY+1];
        for(int i=0;i<answer.length;i++){
            answer[i] = "";
            int cnt = maxX-minX+1;
            for(int j=0;j<cnt;j++){
                answer[i]+=".";
            }
        }
        
        for(int[] tmp : list){
            int x = tmp[0]-minX;
            int y = tmp[1]-minY;
            String s = answer[y];
            if(x<s.length()-1){
                s = s.substring(0,x)+"*"+s.substring(x+1);
            }else{
                s = s.substring(0,x)+"*";
            }
            answer[y] = s;
        }
        
        for(int i=0;i<answer.length/2;i++){
            String tmp = answer[i];
            answer[i] = answer[answer.length-i-1];
            answer[answer.length-i-1] = tmp;
        }
        return answer;
    }
}