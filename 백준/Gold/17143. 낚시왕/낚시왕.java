import java.io.*;
import java.util.*;

/*
1. Shark 클래스를 만듦 (위치, 속력, 방향, 크기, 시간)
2. Shark형의 2차원 배열 map을 만듦,우선순위 큐를 사용해 현재 상어의 위치와 크기 확인
3. 사람이 상어를 잡을 수 있는지 확인 후 잡을 수있다면 맵과 큐에서 지워줌
4. 큐에서 하나씩 빼면서 상어 위치 변경 후 맵에 넣어주는데 시간이 같고 위치가 같다면 누가 더 큰지 판별
 */

class Shark implements Comparable<Shark>{
    int x,y,s,d,z,t;
    public Shark(int x, int y, int s, int d, int z, int t){
        this.x = x;
        this.y = y;
        this.s=  s;
        this.d = d;
        this.z = z;
        this.t = t;
    }

    public int compareTo(Shark o){
        return Integer.compare(this.z,o.z);
    }

    public String toString(){
        return x+" "+y+" "+s+" "+d+" "+z+" "+t;
    }
}
public class Main {
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Shark[][] map = new Shark[R+1][C+1];
        Queue<Shark> q = new LinkedList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());
            int s =Integer.parseInt(st.nextToken());
            int d =Integer.parseInt(st.nextToken());
            int z =Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r,c,s,d,z,0);
            map[r][c] = shark;
            q.offer(shark);
        }

        int answer = 0;

        for(int t=1;t<=C;t++){
            for(int i=1;i<=R;i++){ // 낚시왕이 상어 잡는 것
                if(map[i][t]!=null){
                    answer+=map[i][t].z;
                    q.remove(map[i][t]);
                    map[i][t] = null;
                    break;
                }
            }
            if(t==C) break;
            Queue<Shark> tmpQ = new LinkedList<>();
            while(!q.isEmpty()){
                Shark s = q.poll();
                int sx = s.x; //초기 위치
                int sy = s.y;
                int len = s.s;
                for(int i=0;i<len;i++) {
                    while (true) {
                        int nx = s.x + dx[s.d];
                        int ny = s.y + dy[s.d];
                        if (nx > 0 && nx <= R && ny > 0 && ny <= C) {
                            s.x = nx;
                            s.y = ny;
                            break;
                        } else {
                            if (s.d % 2 == 0) s.d--;
                            else s.d++;
                        }
                    }
                }
                if(map[sx][sy]==s){
                    map[sx][sy] = null;
                }

                if (map[s.x][s.y] == null || map[s.x][s.y].t != s.t + 1) {
                    map[s.x][s.y] = s;
                    s.t++;
                    tmpQ.offer(s);
                }else{
                    if(map[s.x][s.y].z<s.z){
                        tmpQ.remove(map[s.x][s.y]);
                        map[s.x][s.y] = s;
                        s.t++;
                        tmpQ.offer(s);
                    }
                }


            }
            q = tmpQ;
        }

        System.out.println(answer);
    }
}