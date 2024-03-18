import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1 1 2 3
 * 2 5 2 4
 * 3 1 3 5
 * 2 2 1 3
 *
 * 배열로 구성
 * 시계 방향으로 돌릴 경우
 * arr[i][j] = arr[i][(j-k+M)%M]
 * 반시계 방향으로 돌릴 경우
 * arr[i][j] = arr[i][(j+k)%M]
 *
 * 인접하면서 수가 같은 것을 모두 찾는다.
 * 범위 처리 유의
 *
 */
public class Main {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//번호가 xi의 배수인 원판을 di방향으로 ki칸 회전시킨다.
		// di가 0인 경우는 시계 방향, 1인 경우는 반시계 방향이다.
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			// 원판 회전
			for (int j = x; j <= N; j += x) {
				rotateMap(j, d, k);
			}
			// 같은거 있는지 확인(있으면 삭제)
			if (!isContainSame()) {
				//모든 거 다 더해서 +1,-1
				int total = 0;
				int cnt = 0;

				for (int j = 1; j <= N; j++) {
					for (int q = 0; q < M; q++) {
						total += map[j][q];
						if (map[j][q] > 0) {
							cnt++;
						}
					}
				}
				double avg = (double)total / cnt;

				for (int j = 1; j <= N; j++) {
					for (int q = 0; q < M; q++) {
						if (map[j][q] != 0) {
							if (map[j][q] > avg) {
								map[j][q]--;
							} else if (map[j][q] < avg) {
								map[j][q]++;
							}
						}
					}
				}
			}
		}
		int res = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				res += map[i][j];
			}
		}
		System.out.println(res);
	}

	static void rotateMap(int x, int d, int k) {
		int[] tmp = new int[M];

		if (d == 0) { // 시계 방향
			for (int i = 0; i < M; i++) {
				tmp[i] = map[x][(i - k + M) % M];
			}
		} else { // 반시계 방향
			for (int i = 0; i < M; i++) {
				tmp[i] = map[x][(i + k) % M];
			}
		}
		for (int i = 0; i < M; i++) {
			map[x][i] = tmp[i];
		}
	}

	static boolean isContainSame() {
		boolean isContain = false;
		visited = new boolean[N + 1][M];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					if (findNum(i, j)) {
						isContain = true;
					}
				}
			}
		}
		return isContain;
	}


	static boolean findNum(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		boolean isSame = false;
		q.offer(new int[]{x, y});

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int nowX = p[0];
			int nowY = p[1];
			if (nowX != x || nowY != y) {
				map[nowX][nowY] = 0;
			}
			for (int i = 0; i < 4; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				ny = ny == -1 ? M - 1 : ny;
				ny = ny == M ? 0 : ny;
				if (nx > 0 && nx <= N && ny >= 0 && ny < M) {
					if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
						visited[nx][ny] = true;
						isSame = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		if (isSame) {
			map[x][y] = 0;
		}
		return isSame;
	}
}