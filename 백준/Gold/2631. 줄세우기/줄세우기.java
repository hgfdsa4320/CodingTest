import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 3 7 5 2 6 1 4
 * 1 2 2 1 3 1 2
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N + 1];
		int len = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 1; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					len = Math.max(len, dp[i]);
				}
			}
		}
		System.out.println(N - len);

	}
}