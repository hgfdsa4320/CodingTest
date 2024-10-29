import java.util.*;
/**
1. 모든 전선을 연결(리스트 형태)
2. 하나씩 연결을 끊어본다. -> for문 돌려서 wires[i]값인 전선들은 서로 이어져 있지 않다고 가정
3. 송전탑 개수의 차이(하나 구하고 나머지는 n-그 값)을 최소화 -> 완탐
**/
class Solution {
    // 끊을 전선 정보
    static int[] disConnect = new int[2];
    static List<Integer>[] wireList;
    static int answer;
    
    //1번 송전탑이랑 연결되어 있는 송전탑 개수 구하고 연결되어 있지 않은 개수 차이 구함
    static void findNum(int n){
        // 1번 탑이랑 연결되어 있는 송전탑 개수
        int cnt = 1;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<wireList[now].size();i++){
                int next = wireList[now].get(i);
                if(!visited[next] && !disCon(now,next)){
                    visited[next] = true;
                    cnt++;
                    q.offer(next);
                }
            }
        }
        answer = Math.min(answer,Math.abs(cnt-(n-cnt)));
        
    }
    
    static boolean disCon(int a,int b){
        if(disConnect[0]==a&& disConnect[1]==b){
            return true;
        }
        if(disConnect[0]==b&& disConnect[1]==a){
            return true;
        }
        return false;
    }
    
    
    public int solution(int n, int[][] wires) {
        wireList = new ArrayList[n+1];
        answer = Integer.MAX_VALUE;
        
        
        for(int i=1;i<=n;i++){
            wireList[i] = new ArrayList<>();
        }
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            wireList[a].add(b);
            wireList[b].add(a);
        }
        
        for(int i=0;i<wires.length;i++){
            disConnect = wires[i];
            findNum(n);
        }
        return answer;
    }
}