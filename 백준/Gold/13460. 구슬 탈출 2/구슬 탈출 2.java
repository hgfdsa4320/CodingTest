import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int[] dx = {1, 0, -1, 0}; // 남동북서
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'R') {
                    rx = i;
                    ry = j;
                    map[i][j] = '.';
                } else if (s.charAt(j) == 'B') {
                    bx = i;
                    by = j;
                    map[i][j] = '.';
                } else {
                    map[i][j] = s.charAt(j);
                }

            }
        }
        findNum(0, rx, ry, bx, by, 0);  // 방향,구슬 위치, 횟수
        findNum(1, rx, ry, bx, by, 0);
        findNum(2, rx, ry, bx, by, 0);
        findNum(3, rx, ry, bx, by, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void findNum(int d, int rx, int ry, int bx, int by, int cnt) {
        if(cnt>=10) return;
        // 빨간거 부터 이동 후 파란거 이동
        boolean move = true;
        boolean isChange = false;
        while (move) {
            int nrx = rx + dx[d];
            int nry = ry + dy[d];
            int nbx = bx + dx[d];
            int nby = by + dy[d];
            if (map[nbx][nby] == 'O') {
                return;
            }
            move = false;
            if (map[nrx][nry] == '.') {
                if (nrx != bx || nry != by) { // 빨간 구슬이 빈칸으로 움직일 경우
                    rx = nrx;
                    ry = nry;
                    if (map[nbx][nby] == '.') {
                        bx = nbx;
                        by = nby;
                    } 
                    move = true;
                } else { // 빨간 구슬이 파란 구슬로 움직일 경우
                    if (map[nbx][nby] == '.') {
                        rx = nrx;
                        ry = nry;
                        bx = nbx;
                        by = nby;
                        move = true;
                    }
                }
            } else if (map[nrx][nry] == 'O') { // 빨간 구슬이 들어갔을 때
                while (true) {
                    if (map[nbx][nby] == '.') {
                        bx = nbx;
                        by = nby;
                        nbx = bx + dx[d];
                        nby = by + dy[d];
                    } else if (map[nbx][nby] == 'O') {
                        return;
                    } else if (map[nbx][nby] == '#') {
                        answer = Math.min(answer, cnt + 1);
                        return;
                    }
                }
            } else { // 빨간 구슬이 움직이지 않을 경우
                if (map[nbx][nby] == '.') {
                    if (nbx != rx || nby != ry) {
                        bx = nbx;
                        by = nby;
                        move = true;
                    }
                } else if (map[nbx][nby] == 'O') {
                    return;
                }
            }
            if (move) {
                isChange = true;
            }
        }
        if (isChange) {
            for (int i = 0; i < 4; i++) {
                findNum(i, rx, ry, bx, by, cnt + 1);
            }
        }
    }
}