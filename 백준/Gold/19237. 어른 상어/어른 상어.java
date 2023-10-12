import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,-1, 1, 0, 0};
    static int[] dy = {0,0, 0, -1, 1};
    static int[][][] map;

    static class Shark {
        int num;
        int x;
        int y;
        int d;

        public Shark(int num, int x, int y, int d) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][n][3]; // 현재 상어가 있나 : 1 없나 : 0, 상어 냄새 번호, 상어 냄새 잔여 시간
        Queue<Shark> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if (map[i][j][0] > 0) {
                    q.offer(new Shark(map[i][j][0], i, j, 0));
                    map[i][j][1] = map[i][j][0];
                    map[i][j][2] = k;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] direction = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            direction[i] = Integer.parseInt(st.nextToken());
        }
        int len = q.size();
        for (int i = 0; i < len; i++) {
            Shark s = q.poll();
            s.d = direction[s.num];
            q.offer(s);
        }
        int[][][] dir = new int[m + 1][5][5]; // 상어번호, 방향, 우선순위
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 1; l <= 4; l++) {
                    dir[i][j][l] = Integer.parseInt(st.nextToken());
                }
            }
        }
        int t = 0;
        while (q.size() > 1 && t<1001) {
            PriorityQueue<Shark> tmpQ = new PriorityQueue<>((a,b)->a.num-b.num);
            len = q.size();
            for (int i = 0; i < len; i++) {
                Shark s = q.poll();
                boolean flag = true;
                for (int j = 1; j <= 4; j++) { //냄새가 없는 칸이 있는지 확인
                    int nx = s.x + dx[dir[s.num][s.d][j]];
                    int ny = s.y + dy[dir[s.num][s.d][j]];
                    if (nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny][1] == 0) {
                        map[s.x][s.y][0] = 0;
                        flag = false;
                        tmpQ.offer(new Shark(s.num, nx, ny, dir[s.num][s.d][j]));
                        break;
                    }
                }
                if (flag){
                    for (int j = 1; j <= 4; j++) { // 자신의 냄새가 있는 칸
                        int nx = s.x + dx[dir[s.num][s.d][j]];
                        int ny = s.y + dy[dir[s.num][s.d][j]];
                        if (nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny][1] == s.num) {
                            map[s.x][s.y][0] = 0;
                            tmpQ.offer(new Shark(s.num, nx, ny, dir[s.num][s.d][j]));
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j][0] == 0) {
                        if (map[i][j][2] > 1) {
                            map[i][j][2]--;
                        } else if (map[i][j][2] == 1) {
                            map[i][j][1] = 0;
                            map[i][j][2] = 0;
                        }
                    }
                }
            }
            while (!tmpQ.isEmpty()) {
                Shark s = tmpQ.poll();
                if (map[s.x][s.y][0] == 0) {
                    q.offer(s);
                    map[s.x][s.y][0] = s.num;
                    map[s.x][s.y][1] = s.num;
                    map[s.x][s.y][2] = k;
                }
            }
            t++;

        }
        if (t > 1000) {
            System.out.println(-1);
        } else {
            System.out.println(t);
        }

    }
}