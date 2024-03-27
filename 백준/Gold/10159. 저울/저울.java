import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    boolean[][] weight = new boolean[N + 1][N + 1];
    boolean[][] reverseWeight = new boolean[N + 1][N + 1];

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      weight[a][b] = true;
      reverseWeight[b][a] = true;
    }

    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (weight[i][k] && weight[k][j]) {
            weight[i][j] = true;
          }
          if (reverseWeight[i][k] && reverseWeight[k][j]) {
            reverseWeight[i][j] = true;
          }

        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      int cnt = 0;
      for (int j = 1; j <= N; j++) {
        if (i == j) {
          continue;
        }
        if (!weight[i][j] && !reverseWeight[i][j]) {
          cnt++;
        }
      }
      sb.append(cnt).append("\n");
    }
    System.out.println(sb);

  }
}