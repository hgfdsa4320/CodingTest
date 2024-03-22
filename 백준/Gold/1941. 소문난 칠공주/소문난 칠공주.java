import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 25개 중 7개 뽑기 뽑아서 arr[] 배열에 넣기 배열이 모두 모임녀 4명 이상 이다솜파인지 확인 배열 맨앞에 걸 빼서 bfs 돌리고 모두 다 되는지 확인
 */

public class Main {
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static boolean[][] visited;
  static char[][] map;
  static int[] arr;
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    map = new char[5][5];
    arr = new int[7];
    for (int i = 0; i < 5; i++) {
      String s = br.readLine();
      for (int j = 0; j < 5; j++) {
        map[i][j] = s.charAt(j);
      }
    }

    find(0, 0);
    System.out.println(answer);
  }

  static void find(int cnt, int now) {
    if (cnt == 7) {
      int numS = 0;
      for (int i = 0; i < 7; i++) {
        if (map[arr[i] / 5][arr[i] % 5] == 'S') {
          numS++;
        }
      }
      // 다솜파 4명 이상 있는지 확인
      if (numS >= 4) {
        //이웃한지 확인
        visited = new boolean[5][5];
        for (int i = 0; i < 7; i++) {
          visited[arr[i] / 5][arr[i] % 5] = true;
        }
        if (isConnected()) {
          answer++;
        }
      }
      return;
    }

    for (int i = now; i < 25; i++) {
      arr[cnt] = i;
      find(cnt + 1, i + 1);
    }
  }

  static boolean isConnected() {
    Queue<int[]> q = new LinkedList<>();
    visited[arr[0] / 5][arr[0] % 5] = false;
    q.offer(new int[]{arr[0] / 5, arr[0] % 5});

    while (!q.isEmpty()) {
      int x = q.peek()[0];
      int y = q.poll()[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
          if (visited[nx][ny]) {
            visited[nx][ny] = false;
            q.offer(new int[]{nx, ny});
          }
        }
      }
    }
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (visited[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}