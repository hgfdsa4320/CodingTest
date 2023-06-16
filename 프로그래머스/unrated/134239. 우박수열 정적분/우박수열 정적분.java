import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>(); // k값의 변화
        
        while(k>1){
            list.add(k);
            if(k%2==0){
                k/=2;
            }else{
                k=k*3+1;
            }
        }
        list.add(1);
        
        double[] arr = new double[list.size()-1]; // 각각의 넓이
        
        double sum = 0; // 전체 넓이
        for(int i=1;i<list.size();i++){
            arr[i-1] = (list.get(i-1)+list.get(i))/2.0;
            sum+=arr[i-1];
        }
        for(int i=0;i<ranges.length;i++){
            int a = ranges[i][0];
            int b = ranges[i][1];
            double tmp = sum;
            if(a>arr.length || -b>arr.length){
                answer[i] = -1;
                continue;
            }
            
            for(int j=0;j<a;j++){
                tmp-=arr[j];
            }

            for(int j=0;j<-b;j++){
                tmp-=arr[arr.length-1-j];
            }
            if(tmp<0){
                answer[i] = -1;
            }else{
                answer[i] = tmp;                
            }

        }
        return answer;
    }
}