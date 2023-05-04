import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(); //오름차순
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a,b)->b-a); //내림차순
        int size=0;
        for(String operation : operations){
            String[] tmp = operation.split(" ");
            if(tmp[0].equals("I")){
                size++;
                pqMin.offer(Integer.parseInt(tmp[1]));
                pqMax.offer(Integer.parseInt(tmp[1]));
            }else if(tmp[1].equals("-1")){  
                if(!pqMin.isEmpty()){
                    pqMin.poll();
                    if(size>0){
                        size--;    
                    }
                    if(size==0){
                        pqMin = new PriorityQueue<>();
                        pqMax = new PriorityQueue<>((a,b)->b-a);
                    }
                }
            }else{
                if(!pqMax.isEmpty()){
                    pqMax.poll();
                    if(size>0){
                        size--;    
                    }
                    if(size==0){
                        pqMin = new PriorityQueue<>();
                        pqMax = new PriorityQueue<>((a,b)->b-a);
                    }
                }
                
            }
        }
        System.out.println(size);
        if(size==0)
            return new int[]{0,0};
        return new int[]{pqMax.poll(),pqMin.poll()};
    }
}