import java.io.*;
import java.util.*;

public class Main {
    static final int n = 12;
    static final int m = 6;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        findNum();
        System.out.println(answer);
    }
    static void findNum() {
        while (true) {
            boolean flag= true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != '.' && map[i][j] != '0') {
                        char c =  map[i][j];
                        boolean[][] visited = new boolean[n][m];
                        visited[i][j] = true;
                        Queue<int[]> tmpQ = new LinkedList<>();
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{i, j});
                        tmpQ.offer(new int[]{i, j});
                        while (!q.isEmpty()) {
                            int x = q.peek()[0];
                            int y = q.poll()[1];
                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == c && !visited[nx][ny]) {
                                    visited[nx][ny] = true;
                                    q.offer(new int[]{nx, ny});
                                    tmpQ.offer(new int[]{nx, ny});
                                }
                            }
                        }
                        if (tmpQ.size() >= 4) {
                            while (!tmpQ.isEmpty()) {
                                int x = tmpQ.peek()[0];
                                int y = tmpQ.poll()[1];
                                map[x][y] = '0';
                                flag= false;
                            }
                        }
                    }

                }
            }
            if (flag) {
                break;
            } else {
                changeMap();
            }
            answer++;
        }
    }

    static void changeMap() {
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i > 0; i--) {
                if (map[i][j] == '0') {
                    while (map[i][j] == '0') {
                        for (int k = i; k > 0; k--) {
                            map[k][j] = map[k - 1][j];
                        }
                        map[0][j] = '.';
                    }
                }
            }

        }
    }

}