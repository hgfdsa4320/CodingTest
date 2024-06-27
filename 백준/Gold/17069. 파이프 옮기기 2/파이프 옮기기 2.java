import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 방향은 크게
 * 가로 : 0 -> 기준 좌표 : 오른쪽
 * 세로 : 1 -> 기준 좌표 : 아래
 * 대각선 : 2 -> 기준 좌표 : 오른쪽 아래
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][][] dp = new long[N + 1][N + 1][3];
		dp[1][2][0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 현재 위치가 벽인 경우
				if(map[i][j]==1) continue;
				if (j - 1 > 0) {
					// 가로 방향일 때, 오른쪽으로 민 경우
					dp[i][j][0] += dp[i][j - 1][0];
					// 대각선 방향이었을 때,오른쪽 방향이 된 경우
					dp[i][j][0] += dp[i][j - 1][2];
				}
				if (i - 1 > 0 && j - 1 > 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
					// 가로 방향일 때, 오른쪽 아래 대각선으로 민 경우
					dp[i][j][2] += dp[i - 1][j - 1][0];
					// 세로 방향일 때, 오른쪽 대각선으로 민 경우
					dp[i][j][2] += dp[i - 1][j - 1][1];
					// 대각선 방향일 때, 대각선 방향으로 민 경우
					dp[i][j][2] += dp[i - 1][j - 1][2];
				}
				if (i - 1 > 0) {
					// 세로 방향일 때, 아래쪽 방향으로 민 경우
					dp[i][j][1] += dp[i - 1][j][1];
					// 대각선 방향이었을 때, 아래쪽 방향으로 바뀐 경우
					dp[i][j][1] += dp[i - 1][j][2];
				}

			}
		}
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
}