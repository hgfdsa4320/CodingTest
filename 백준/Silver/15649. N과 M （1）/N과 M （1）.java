import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[] arr;
  static StringBuilder sb;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    boolean[] visited = new boolean[N + 1];
    arr = new int[N + 1];
    sb = new StringBuilder();
    find(1, visited);
    System.out.println(sb);
  }

  static void find(int now, boolean[] visited) {
    if (now == M + 1) {
      for (int i = 1; i <= M; i++) {
        sb.append(arr[i]).append(" ");
      }
      sb.append("\n");
      return;
    }
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[now] = i;
        find(now + 1, visited);
        visited[i] = false;
      }
    }
  }
}