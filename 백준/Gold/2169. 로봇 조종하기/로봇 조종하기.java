import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * dp 같은데
 */
public class Main {
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N + 1][M + 1];
		dp[1][1] = map[1][1];
		for (int i = 2; i <= M; i++)
			dp[1][i] = dp[1][i - 1] + map[1][i];

		for (int i = 2; i <= N; i++) {
			int[][] temp = new int[M + 1][2];
			temp[1][0] = dp[i - 1][1] + map[i][1];
			for (int j = 2; j <= M; j++) {
				temp[j][0] = Math.max(temp[j - 1][0], dp[i - 1][j]) + map[i][j];
			}
			temp[M][1] = dp[i - 1][M] + map[i][M];
			for (int j = M - 1; j >= 1; j--) {
				temp[j][1] = Math.max(temp[j + 1][1], dp[i - 1][j]) + map[i][j];
			}
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Math.max(temp[j][0], temp[j][1]);
			}
		}
		System.out.println(dp[N][M]);
	}

}