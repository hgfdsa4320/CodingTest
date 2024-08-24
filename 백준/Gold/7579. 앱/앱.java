import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * int[] dp = new int[10001]-> 비용이 i일때 확보할 수 있는 메모리
 * 5 60
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] c = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[10001];
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 10000; j >= c[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - c[i]] + arr[i]);
				if (dp[j] >= M) {
					answer = Math.min(answer, j);
				}
			}
		}
		System.out.println(answer);
	}
}