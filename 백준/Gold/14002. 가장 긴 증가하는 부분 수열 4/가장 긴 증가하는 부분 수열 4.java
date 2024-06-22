import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] arr = new int[N + 1];
		int[] record = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i - 1; j++) {
				if (arr[j] < arr[i] && dp[i] <= dp[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					record[i] = j;
				}
			}
			if (dp[i] > answer) {
				answer = dp[i];
				idx = i;
			}
			answer = Math.max(answer, dp[i]);

		}

		Stack<Integer> stack = new Stack<>();
		int now = idx;

		while (now > 0) {
			stack.push(arr[now]);
			now = record[now];
		}
		System.out.println(answer);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
}

/**
 *
 * 10 20 50 40 50
 */