import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean stop = false;
        while (!stop) {
            int nd = d;
            if (map[r][c] == 0) {
                map[r][c] = 2;
            } else {
                int cnt = 0;
                while (true) {
                    nd = nd == 0 ? 3 : nd - 1;
                    cnt++;
                    int nr = r + dx[nd];
                    int nc = c + dy[nd];
                    if (map[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        d = nd;
                        break;
                    }
                    if (cnt == 4) {
                        nd = (nd + 2) % 4;
                        nr = r + dx[nd];
                        nc = c + dy[nd];
                        if (map[nr][nc] != 1) {
                            r = nr;
                            c = nc;
                        } else {
                            stop = true;
                        }
                        break;
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}