import java.io.*;
import java.util.*;


public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Point>[][] map;
    static int n;
    static boolean[][] isTurnOn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isTurnOn = new boolean[n + 1][n + 1];
        map = new ArrayList[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[x][y].add(new Point(a, b));
        }
        int answer = findNum(1, 1);
        System.out.println(answer);
    }

    static int findNum(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        q.offer(new Point(x, y));
        isTurnOn[x][y] = true;
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;
            List<Point> list = map[x][y];
            for (Point point : list) {
                isTurnOn[point.x][point.y] = true;
                if (!visited[point.x][point.y]) {
                    boolean isVisited = false;
                    for (int i = 0; i < 4; i++) {
                        int nx = point.x + dx[i];
                        int ny = point.y + dy[i];
                        if (isInMap(nx, ny) && visited[nx][ny]) {
                            isVisited = true;
                            break;
                        }
                    }
                    if (isVisited) {
                        visited[point.x][point.y] = true;
                        q.offer(new Point(point.x, point.y));
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isInMap(nx,ny) && isTurnOn[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }


        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (isTurnOn[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static boolean isInMap(int x, int y) {
        if (x > 0 && x <= n && y > 0 && y <= n) {
            return true;
        }
        return false;
    }
}