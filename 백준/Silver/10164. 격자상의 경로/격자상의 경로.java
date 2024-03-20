import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int[][] map;
  static int[] dx = {0, 1};
  static int[] dy = {1, 0};
  static int answer = 0;
  static int N, M, K;
  static int sum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[N + 1][M + 1];
    map[K / M + 1][K % M] = 1;
    sum = K == 0 ? 0 : 1;
    find(1, 1, 0);
    System.out.println(answer);
  }

  static void find(int x, int y, int now) {
    if (x == N && y == M) {
      if (now == sum) {
        answer++;
      }
      return;
    }
    for (int i = 0; i < 2; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
        find(nx, ny, now + map[nx][ny]);
      }
    }
  }
}