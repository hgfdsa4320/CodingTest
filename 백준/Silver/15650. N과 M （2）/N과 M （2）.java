import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static boolean[] visited;
  static int[] arr;
  static int N, M;
  static StringBuilder sb;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N];
    arr = new int[M];
    sb = new StringBuilder();
    findNum(0, 0);
    System.out.println(sb);
  }

  static void findNum(int cnt,int start) {
    if (cnt == M) {
      for (int i : arr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }
    for (int i = start; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[cnt] = i + 1;
        findNum(cnt + 1, i + 1);
        visited[i] = false;
      }
    }
  }
}