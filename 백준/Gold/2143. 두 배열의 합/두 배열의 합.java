import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n+1];
    int[] sumA = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
      sumA[i] = sumA[i - 1] + a[i];
    }
    int m = Integer.parseInt(br.readLine());
    int[] b = new int[m + 1];
    int[] sumB = new int[m + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
      sumB[i] = sumB[i - 1] + b[i];
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= m; i++) {
      for (int j = 0; j < i; j++) {
        list.add(sumB[i] - sumB[j]);
      }
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        int now = sumA[i] - sumA[j];
        map.put(now, map.getOrDefault(now, 0) + 1);
      }
    }
    long cnt = 0;
    for (int i = 0; i < list.size(); i++) {
      if (map.containsKey(T - list.get(i))) {
        cnt += map.get(T - list.get(i));
      }
    }
    System.out.println(cnt);
  }
}