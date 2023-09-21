import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dice = new int[7]; // 주사위 인덱스 = 주사위 값
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] order = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            int nx = x + dx[order[i]];
            int ny = y + dy[order[i]];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (order[i] == 1) {
                    int tmp = dice[6];
                    dice[6] = dice[3];
                    dice[3] = dice[1];
                    dice[1] = dice[4];
                    dice[4] = tmp;

                } else if (order[i] == 2) {
                    int tmp = dice[6];
                    dice[6] = dice[4];
                    dice[4] = dice[1];
                    dice[1] = dice[3];
                    dice[3] = tmp;

                } else if (order[i] == 3) {
                    int tmp = dice[6];
                    dice[6] = dice[2];
                    dice[2] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = tmp;
                } else {
                    int tmp = dice[6];
                    dice[6] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = dice[2];
                    dice[2] = tmp;
                }
                if (map[nx][ny] == 0) {
                    map[nx][ny] = dice[6];
                } else {
                    dice[6] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                x = nx;
                y = ny;
                System.out.println(dice[1]);
            }
        }
    }
}