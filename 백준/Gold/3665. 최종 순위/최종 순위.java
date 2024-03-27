import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < T; tc++) {
      int n = Integer.parseInt(br.readLine());
      int[] order = new int[n + 1];
      List<Integer>[] arr = new ArrayList[n + 1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      boolean[] check = new boolean[n + 1];
      for (int i = 1; i <= n; i++) {
        arr[i] = new ArrayList<>();
      }
      for (int i = 1; i <= n; i++) {
        order[i] = Integer.parseInt(st.nextToken());
        check[order[i]] = true;
        for (int j = 1; j <= n; j++) {
          if (!check[j]) {
            arr[j].add(order[i]);
          }
        }
      }
      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        // a가 b보다 앞에 있는 경우
        if (arr[a].contains(b)) {
          arr[a].remove(Integer.valueOf(b));
          arr[b].add(a);
        } else {
          arr[b].remove(Integer.valueOf(a));
          arr[a].add(b);
        }
      }

      Queue<Integer> q = new LinkedList<>();
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= n; i++) {
        if (arr[i].size() == 0) {
          q.offer(i);
          sb.append(i).append(" ");
        }

      }
      boolean isPossible = true;
      for (int t= 0; t < n; t++) {
        if (q.isEmpty() || q.size() > 1) {
          isPossible = false;
          break;
        }

        Integer p = q.poll();
        for (int i = 1; i <= n; i++) {
          if (arr[i].contains(p)) {
            arr[i].remove(Integer.valueOf(p));
            if (arr[i].size() == 0) {
              q.offer(i);
              sb.append(i).append(" ");
            }
          }
        }
      }
      if (isPossible) {
        System.out.println(sb);
      } else {
        System.out.println("IMPOSSIBLE");
      }
    }
  }

}