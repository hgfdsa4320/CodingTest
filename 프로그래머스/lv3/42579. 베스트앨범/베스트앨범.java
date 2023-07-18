import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
       
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<plays.length;i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }
        // {genre,play} play 기준 내림차순 정렬
        PriorityQueue<String[]> pq = new PriorityQueue<>((a,b)->Integer.parseInt(b[1])-Integer.parseInt(a[1]));
        for(String s : map.keySet()){
            pq.offer(new String[]{s,String.valueOf(map.get(s))});
        }
        
        List<Integer> res = new ArrayList<>();
        //{idx,play} play횟수 기준 내림차순 정렬 같으면 idx기준 오름차순 정렬
        List<int[]> list = new ArrayList<>();
        while(!pq.isEmpty()){
            String[] tmp = pq.poll();
            String genre = tmp[0];
            for(int i=0;i<genres.length;i++){
                if(genres[i].equals(genre)){
                    list.add(new int[]{i,plays[i]});
                }
            }
            Collections.sort(list,(a,b)->(a[1]==b[1])?a[0]-b[0]:b[1]-a[1]);
            if(list.size()==1){
                res.add(list.get(0)[0]);
            }else{
                res.add(list.get(0)[0]);
                res.add(list.get(1)[0]);
            }
            list = new ArrayList<>();
            
        }
        int[] answer = new int[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
}