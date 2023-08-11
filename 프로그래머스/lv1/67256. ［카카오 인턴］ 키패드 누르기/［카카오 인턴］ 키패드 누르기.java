import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"00");
        map.put(2,"01");
        map.put(3,"02");
        map.put(4,"10");
        map.put(5,"11");
        map.put(6,"12");
        map.put(7,"20");
        map.put(8,"21");
        map.put(9,"22");
        map.put(0,"31");
      
        int lx = 3;
        int ly = 0;
        int rx = 3;
        int ry = 2;
       
        for(int number : numbers){
                   
            if(number==1 || number==4 || number==7){
                sb.append("L");
                lx = map.get(number).charAt(0)-'0';
                ly = map.get(number).charAt(1)-'0';
            }else if(number==3 || number==6 || number==9){
                sb.append("R");
                rx = map.get(number).charAt(0)-'0';
                ry = map.get(number).charAt(1)-'0';
            }else{
                int x = map.get(number).charAt(0)-'0';
                int y = map.get(number).charAt(1)-'0';
                int cntLeft = distance(x,y,lx,ly);
                int cntRight = distance(x,y,rx,ry);
                if(cntLeft == cntRight){
                    if(hand.equals("left")){
                        sb.append("L");
                        lx = x;
                        ly = y;
                    }else{
                        sb.append("R");
                        rx = x;
                        ry = y;
                    }
                }else if(cntLeft<cntRight){
                    sb.append("L");
                    lx = x;
                    ly = y;
                }else{
                    sb.append("R");
                    rx = x;
                    ry = y;
                }
            }
        } 
        return sb.toString();
    }
    static int distance(int x,int y,int px,int py){
        boolean[][] visited = new boolean[4][3];
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,0});
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0]==px && tmp[1]==py){
                return tmp[2];
            }
            for(int i=0;i<4;i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx>=0 && nx<4 && ny>=0 && ny<3 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,tmp[2]+1});
                }
            }
        }
        
        return 0;
        
    }
}