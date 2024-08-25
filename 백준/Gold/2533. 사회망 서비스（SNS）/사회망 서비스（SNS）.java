import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * dp[i][0] => i번째 친구가 얼리어 답터가 아닐 경우
 * dp[i][1] => i번째 친구가 얼리어 답터일 경우
 *
 * 8
 * 1 2
 * 1 3
 * 1 4
 * 2 5
 * 2 6
 * 4 7
 * 4 8
 * dp[1][0] => 1과 연결된 친구들이 다 얼리어답터여야함
 * -> dp[1][0] => dp[2][1]+dp[3][1]+dp[4][1]
 * dp[1][1]
 * -> Math.min(dp[2][0],dp[2][1])+Math.min(dp[3][0],dp[3][1])+Math.min(dp[4][0],dp[4][1])
 * 이런식으로 구하고 dp[1][0],dp[1][1] 중 최솟 값
 *
 * for(int i=N;i>=1;i--){
 *     dp[i][0] = -> 연결된 친구들
 *     dp[i][1] = -> 연결된 친구들 얼리어답터랑 아닐경우 중 최솟값의 합
 *     dp[1][0] = dp[2][1]+
 * }
 */
public class Main {
	static int N;
	static int[][] dp;
	static List<Integer>[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][2];

		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);
		}
		visited = new boolean[N + 1];
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	static void dfs(int now) { //state가 1이면 얼리어답터
		visited[now] = true;
		dp[now][0] = 0;
		dp[now][1] = 1;

		for (int next : arr[now]) {
			if (!visited[next]) {
				dfs(next);
				dp[now][0] += dp[next][1];
				dp[now][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	}
}