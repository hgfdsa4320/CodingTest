import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 던진 막대기가 미네랄을 만나면 지워주고 분리 된 클러스터가 있는지 확인한다(bfs돌리면서 바닥에 붙어있는지 확인) -> 바로 리턴하지 않고 다 확인
 * 바닥에 붙어있느 않은 클러스터가 있다면 바닥으로 내려준다.
 * 내려줄때는 가장 밑에 있는 미네랄이 바닥 혹은 미네랄에 닿을 때까지 높이를 계산하고 모든 미네랄을 그 높이만큼 내려준다.
 */

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String s = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = s.charAt(j-1);
            }
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            throwStick(i, R-height+1);
            checkMap();
        }
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void throwStick(int d, int height) {
        if (d % 2 == 1) { //왼쪽에서 던짐
            for (int i = 1; i <= C; i++) {
                if (map[height][i] == 'x') {
                    map[height][i] = '.';
                    break;
                }
            }
        } else { // 오른쪽에서 던짐
            for (int i = C; i >= 1; i--) {
                if (map[height][i] == 'x') {
                    map[height][i] = '.';
                    break;
                }
            }
        }
    }

    static void checkMap() {
        visited = new boolean[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] == 'x' && !visited[i][j]) {
                    if (separate(i, j)) { //분리되어 있으면
                        return;
                    }
                }
            }
        }
    }

    static boolean separate(int x,int y) {
        boolean isSeparate = true;
        Queue<Point> q = new LinkedList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> b.x - a.x);
        Set<String> checkMine = new HashSet<>();
        checkMine.add(x + "-" + y);
        q.offer(new Point(x, y));
        pq.offer(new Point(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;
            if (x == R) {
                isSeparate = false;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx > 0 && nx <= R && ny > 0 && ny <= C && !visited[nx][ny] && map[nx][ny] == 'x') {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                    pq.offer(new Point(nx, ny));
                    checkMine.add(nx + "-" + ny);
                }
            }
        }
        if (isSeparate) {
            List<Point> tmp = new ArrayList<>();
            while (!pq.isEmpty()) {
                tmp.add(pq.poll());
            }

            // 몇칸을 내려야 되는지 확인
            int cnt = Integer.MAX_VALUE;
            for (int i = 0; i < tmp.size(); i++) {
                Point p = tmp.get(i);
                int c = 1;
                while (true) {
                    if (p.x + c == R + 1 || (map[p.x + c][p.y] == 'x' && !checkMine.contains(p.x + c + "-" + p.y))) {
                        cnt = Math.min(cnt, c - 1);
                        break;
                    }
                    c++;
                }
                pq.offer(p);
            }
            //전부 내림
            while (!pq.isEmpty()) {
                Point p = pq.poll();
                map[p.x + cnt][p.y] = 'x';
                map[p.x][p.y] = '.';
            }
        }
        return isSeparate;
    }
}