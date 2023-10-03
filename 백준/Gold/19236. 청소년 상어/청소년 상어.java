import java.io.*;
import java.util.*;

public class Main {
    static class Fish {
        int size;
        int x;
        int y;
        int d;

        public Fish(int size, int x, int y, int d) {
            this.size = size;
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public String toString() {
            return size + " " + x + " " + y + " " + d;
        }
    }

    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[][] map = new Fish[4][4];
        answer = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int size = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                map[i][j] = new Fish(size, i, j, d);
            }
        }
        int initSize = map[0][0].size;
        map[0][0].size = 100; //상어는 크기를 100으로 설정
        findMax(0, 0, map, initSize);
        System.out.println(answer);
    }

    static void findMax(int x, int y, Fish[][] map, int score) {
        answer = Math.max(answer, score);

        Fish[][] tmpMap = copy(map);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tmpMap[i][j].size > 0 && tmpMap[i][j].size <= 16) {
                    pq.offer(tmpMap[i][j].size);
                }
            }
        }
        int len = pq.size();
        for (int i = 0; i < len; i++) {
            int size = pq.poll();
            int fx =0;
            int fy = 0;
            int d = 0;
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (tmpMap[j][k].size == size) {
                        fx = j;
                        fy = k;
                        d = tmpMap[j][k].d;
                    }
                }
            }
            for (int j = 0; j < 8; j++) {
                int nfx = fx + dx[d];
                int nfy = fy + dy[d];
                if (nfx >= 0 && nfx < 4 && nfy >= 0 && nfy < 4 && tmpMap[nfx][nfy].size <= 16) {
                    tmpMap[fx][fy] = new Fish(tmpMap[nfx][nfy].size, tmpMap[nfx][nfy].x, tmpMap[nfx][nfy].y, tmpMap[nfx][nfy].d);
                    tmpMap[nfx][nfy] = new Fish(size, fx, fy, d);
                    break;
                }
                d = d == 8 ? 1 : d + 1;
            }
        }
        int sx = x;
        int sy = y;
        int sd = tmpMap[x][y].d;
        for (int i = 0; i < 3; i++) {
            sx+=dx[sd];
            sy+=dy[sd];
            if (sx >= 0 && sx < 4 && sy >= 0 && sy < 4 && tmpMap[sx][sy].size > 0 && tmpMap[sx][sy].size <= 16) {
                Fish[][] nextMap = copy(tmpMap);
                nextMap[x][y].size=0;
                nextMap[sx][sy].size=100;
                findMax(sx, sy, nextMap, score + tmpMap[sx][sy].size);
            }

        }
    }

    static Fish[][] copy(Fish[][] map) {
        Fish[][] tmpMap = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tmpMap[i][j] = new Fish(map[i][j].size, map[i][j].x, map[i][j].y, map[i][j].d);
            }
        }
        return tmpMap;
    }
}