import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] outside;
    static int n, m;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        outside = new boolean[n][m];
        map = new int[n][m];
        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) q.offer(new int[]{i, j});
            }
        }
        int answer = findTime();
        System.out.println(answer);
    }

    static int findTime() {
        int time = 0;
        while (true) {
            checkOutside();
            int len = q.size();
            if(len==0) break;
            time++;
            for (int i = 0; i < len; i++) {
                int x = q.peek()[0];
                int y = q.poll()[1];
                int cnt = 0;
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && outside[nx][ny]) {
                        cnt++;
                    }
                }
                if (cnt < 2) {
                    q.offer(new int[]{x, y});
                }else{
                    map[x][y] = 0;
                }
            }
        }
        return time;
    }

    static void checkOutside() {
        outside = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if(map[i][0] == 0 && !outside[i][0]) {
                dfs(i, 0);
            }else if(map[i][m-1] == 0 && !outside[i][m-1]) {
                dfs(i, m-1);
            }
        }
        for (int i = 0; i < m; i++) {
            if (map[0][i] == 0 && !outside[0][i]) {
                dfs(0, i);
            }else if(map[n-1][i] == 0 && !outside[n-1][i]) {
                dfs(n-1, i);
            }
        }
    }

    static void dfs(int x, int y) {
        outside[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0 && !outside[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}