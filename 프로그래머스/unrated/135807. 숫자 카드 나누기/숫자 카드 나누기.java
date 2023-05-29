import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        PriorityQueue<Integer> pqA = new PriorityQueue<>((a,b)->b-a); // 배열A의 가장 작은 수의 약수
        PriorityQueue<Integer> pqB = new PriorityQueue<>((a,b)->b-a); // 배열B의 가장 작은 수의 약수
        
        
        // 배열A의 가장 작은 수의 약수 구하기
        for(int i=1;i<=Math.sqrt(arrayA[0]);i++){
            if(arrayA[0]%i==0){
                pqA.add(i);
                pqA.add(arrayA[0]/i);
            }
        }
        
        // 배열B의 가장 작은 수의 약수 구하기
        for(int i=1;i<=Math.sqrt(arrayB[0]);i++){
            if(arrayB[0]%i==0){
                pqB.add(i);
                pqB.add(arrayB[0]/i);
            }
        }
        
        
        while(!pqA.isEmpty() || !pqB.isEmpty()){
            int a = 0;
            int b = 0;
            if(!pqA.isEmpty()){
                a = pqA.peek();
            }
            if(!pqB.isEmpty()){
                b = pqB.peek();
            }
            boolean isAnswer=true;
            if(a>b){
                pqA.poll();
                for(int i=0;i<arrayA.length;i++){
                    if(arrayA[i]%a!=0){
                        isAnswer=false;
                        break;
                    }
                    else if(arrayB[i]%a==0){
                        isAnswer=false;
                        break;
                    }
                }
                if(isAnswer){
                    answer = a;
                    break;
                }
            }else{
                pqB.poll();
                for(int i=0;i<arrayA.length;i++){
                    if(arrayA[i]%b==0){
                        isAnswer=false;
                        break;
                    }
                    else if(arrayB[i]%b!=0){
                        isAnswer=false;
                        break;
                    }
                }
                if(isAnswer){
                    answer = b;
                    break;
                }
            }
        }
        return answer;
    }
}