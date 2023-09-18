import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n,m;
    static int[][] map;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        wall(0);
        System.out.println(answer);
    }
    static void wall(int cnt){
        if (cnt == 3) {
            virus();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j]=1;
                    wall(cnt + 1);
                    map[i][j]=0;
                }
            }
        }
    }

    static void virus() {
        int[][] tmp = copy(map);
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (true) {
            int len = q.size();
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                int x = q.peek()[0];
                int y = q.poll()[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && tmp[nx][ny] == 0) {
                        tmp[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                        cnt++;
                    }
                }
            }
            if(cnt==0) break;
        }
        int safeZone = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        answer = Math.max(answer, safeZone);
    }

    static int[][] copy(int[][] arr){
        int[][] tmp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }
}