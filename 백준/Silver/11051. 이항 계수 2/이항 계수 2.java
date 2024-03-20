import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] memo;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    memo = new int[N + 1][N + 1];
    K = Math.min(K, N-K);

    System.out.println(combination(N, K));
  }

  static int combination(int a, int b) {
    if (a == 1 || b == 0 || a == b) {
      return 1;
    }
    if (memo[a][b] != 0) {
      return memo[a][b];
    }
    return memo[a][b] = (combination(a - 1, b - 1) % 10007 + combination(a - 1, b) % 10007) % 10007;
  }
}