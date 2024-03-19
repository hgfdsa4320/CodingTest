import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
  static BigInteger[][] arr;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    arr = new BigInteger[101][101];
    for (int i = 0; i <= 100; i++) {
      for (int j = 0; j <= 100; j++) {
        arr[i][j] = BigInteger.ZERO;
      }
    }
    m = m > n / 2 ? n - m : m;

    System.out.println(find(n, m));
  }

  static BigInteger find(int a, int b) {
    if (a == 1 || b == 0 || (a == b)) {
      return BigInteger.ONE;
    }
    if (!arr[a][b].equals(BigInteger.ZERO)) {
      return arr[a][b];
    }
    return arr[a][b] = find(a - 1, b).add(find(a - 1, b - 1));
  }
}