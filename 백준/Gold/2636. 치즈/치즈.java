import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int n, m;
    static List<Integer> prevList;
    static boolean[][] outside;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        prevList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = findTime();
        System.out.println(answer);
        System.out.println(prevList.get(prevList.size()-2));
    }
    static int findTime() {
        int time = 0;

        while (true) {
            outside = new boolean[n][m];
            findOutside();
            boolean flag = true;
            int prev = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int tx = i + dx[k];
                            int ty = j + dy[k];
                            if(tx>=0 && tx<n && ty>=0 && ty<m && outside[tx][ty]){
                                cnt++;
                                flag = false;
                            }
                        }
                        if (cnt > 0) {
                            prev++;
                            map[i][j] = 0;
                        }
                    }
                }
            }
            prevList.add(prev);
            if (flag) {
                break;
            }
            time++;

        }
        return time;


    }

    static void findOutside() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1 && !outside[i][j]) {
                    changeOutside(i, j);
                }
            }
        }
    }

    static void changeOutside(int x, int y) {
        outside[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0 && !outside[nx][ny]) {
                changeOutside(nx, ny);
            }
        }
    }
}