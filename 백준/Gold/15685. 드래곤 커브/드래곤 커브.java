import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1.큐를 사용하여 드래곤 커브를 넣고
2.다음 세대 드래곤 커브를 만들고 범위 안에 들어간다면 큐에 넣어줌
3.네 꼭지점을 모두 방문했으면 값 증가 시켜줌
*/
public class Main {
    static class QueueInput {
        int x;
        int y;
        StringBuilder sb;

        public QueueInput(int x, int y, StringBuilder sb) {
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<QueueInput> q;
    static final int n = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[n][n];
        visited = new boolean[n][n];
        q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            findDragonCurve(x, y, d, g);
        }

        int answer = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static QueueInput findDragonCurve(int x, int y, int d, int g) {
        visited[x][y] = true;
        x += dx[d];
        y += dy[d];
        visited[x][y] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(d);
        for (int i = 0; i < g; i++) {
            StringBuilder reverseSb = new StringBuilder(sb.toString());
            reverseSb.reverse();
            for (int j = 0; j < reverseSb.length(); j++) {
                int tmp = reverseSb.charAt(j) - '0';
                int next = tmp == 3 ? 0 : tmp + 1;
                x += dx[next];
                y += dy[next];
                visited[x][y] = true;
                sb.append(next);
            }
        }
        return new QueueInput(x, y, sb);

    }
}