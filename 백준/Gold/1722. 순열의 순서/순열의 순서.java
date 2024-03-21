import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    if (a == 1) {
      find(Long.parseLong(st.nextToken()));
    } else {
      int[] arr = new int[N + 1];
      for (int i = 1; i <= N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(findOrder(arr));
    }
  }

  static void find(long a) {
    StringBuilder sb = new StringBuilder();
    int[] arr = new int[N + 1];
    boolean[] visited = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = i;
    }

    for (int cnt = 1; cnt <= N; cnt++) {
      int order = 0;
      while (a - factorial(N - cnt) > 0) {
        a -= factorial(N - cnt);
        order++;
      }
      for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
          if (order == 0) {
            visited[i] = true;
            sb.append(i).append(" ");
            break;
          } else {
            order--;
          }
        }
      }
    }
    System.out.println(sb);
  }

  static long factorial(int n) {
    if (n == 1 || n == 0) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  static long findOrder(int[] arr) {
    long answer = 1;
    boolean[] visited = new boolean[N + 1];
    for (int order = 1; order <= N; order++) {
      int cnt = 0;
      for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
          if (arr[order] != i) {
            cnt++;
          } else {
            visited[i] = true;
            break;
          }
        }
      }
      answer += cnt * factorial(N - order);
    }
    return answer;
  }
}