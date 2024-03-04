import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] map = new int[N][M];
        int[][] res = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j)-'0';
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        res[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int x = tmp[0];
            int y = tmp[1];
            int w = tmp[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int next = map[nx][ny] == 1 ? 1 : 0;
                    if (w + next < res[nx][ny]) {
                        res[nx][ny] = w + next;
                        pq.offer(new int[]{nx, ny, res[nx][ny]});
                    }
                }
            }
        }
       
        System.out.println(res[N - 1][M - 1]);
    }
}