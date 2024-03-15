import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, answer;
  static char[][] map;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    answer = Integer.MIN_VALUE;
    map = new char[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      String s = br.readLine();
      for (int j = 1; j <= N; j++) {
        map[i][j] = s.charAt(j - 1);
      }
    }
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        find(i, j);
      }
    }
    System.out.println(answer);
  }

  static void find(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
        if (map[x][y] != map[nx][ny]) {
          swap(x, y, nx, ny);
          int len = findLength();
          answer = Math.max(answer, len);
          swap(x, y, nx, ny);
        }
      }
    }
  }

  static void swap(int x, int y, int nx, int ny) {
    char tmp = map[x][y];
    map[x][y] = map[nx][ny];
    map[nx][ny] = tmp;
  }

  static int findLength() {
    int len = 0;
    for (int i = 1; i <= N; i++) {
      char now = '0';
      int cnt = 0;
      for (int j = 1; j <= N; j++) {
        if (map[i][j] == now) {
          cnt++;
          len = Math.max(len, cnt);
        } else {
          now = map[i][j];
          cnt = 1;
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      char now = '0';
      int cnt = 0;
      for (int j = 1; j <= N; j++) {
        if (map[j][i] == now) {
          cnt++;
          len = Math.max(len, cnt);
        } else {
          now = map[j][i];
          cnt = 1;
        }
      }
    }

    return len;
  }
}