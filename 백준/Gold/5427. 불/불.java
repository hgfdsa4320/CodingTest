import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Input {
    int time;
    int x;
    int y;

    public Input(int time, int x, int y) {
        this.time = time;
        this.x=x;
        this.y = y;
    }
}
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PriorityQueue<Input> pq;
    static int h, w;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            pq = new PriorityQueue<>((a, b) -> a.time - b.time);
            int sx = 0;
            int sy = 0;
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '*') {
                        pq.offer(new Input(0, i, j));
                    } else if (map[i][j] == '@') {
                        map[i][j] = '.';
                        sx = i;
                        sy = j;
                    }
                }
            }

            int answer = findTime(sx, sy);
            if (answer == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(answer);
            }
        }
    }

    static int findTime(int sx, int sy) {
        PriorityQueue<Input> personPq = new PriorityQueue<>((a, b) -> a.time - b.time);
        boolean[][] visited = new boolean[h][w];
        visited[sx][sy] = true;
        personPq.offer(new Input(0, sx, sy));
        int currentTime = 0;
        while (!personPq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek().time == currentTime) {
                Input p = pq.poll();
                int time = p.time;
                int x = p.x;
                int y = p.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = '*';
                            pq.offer(new Input(time + 1, nx, ny));
                        }
                    }
                }
            }

            while (!personPq.isEmpty() && personPq.peek().time == currentTime) {
                Input p = personPq.poll();
                int time = p.time;
                int x = p.x;
                int y = p.y;
                if (x == 0 || x == h - 1 || y == 0 || y == w - 1) {
                    return time + 1;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (map[nx][ny] == '.' && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            personPq.offer(new Input(time + 1, nx, ny));
                        }
                    }
                }
            }
            currentTime++;

        }
        return -1;
    }
}