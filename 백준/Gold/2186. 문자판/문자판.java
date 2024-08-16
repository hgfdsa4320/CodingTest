import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * 메모이제이션을 이용한 DFS
 * dp[][][] -> [x][y]좌표에서 -> depth 번째부터 끝까지 갈수 있는 개수
 *
 */
public class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M, K;
	static char[][] map;
	static String word;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		word = br.readLine();
		dp = new int[N][M][word.length()];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		char start = word.charAt(0);
		int answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == start) {
					answer += dfs(i, j, 0);
				}
			}
		}
		System.out.println(answer);
	}

	static int dfs(int x, int y, int depth) {
		if (dp[x][y][depth] != -1) {
			return dp[x][y][depth];
		}
		if (depth == word.length() - 1) {
			return 1;
		}
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= K; j++) {
				int nx = x + dx[i] * j;
				int ny = y + dy[i] * j;
				if (!isInMap(nx, ny))
					continue;
				if (map[nx][ny] == word.charAt(depth + 1)) {
					cnt += dfs(nx, ny, depth + 1);
				}
			}
		}
		return dp[x][y][depth] = cnt;
	}

	static boolean isInMap(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<M) return true;
		return false;
	}

}