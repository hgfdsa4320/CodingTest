import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * N * M 행렬 -> 0 : 이동할 수 있는 곳, 1 : 이동할 수 없는 곳
 * 목표 : (1,1) -> (N,M)으로 이동하기 위한 최단거리(시작하는 칸과 끝나는 칸도 세기)
 * 벽을 부수고 이동하는 것이 경로가 더 짧아진다면 최대 K개까지 벽을 부술 수 있다
 * 1000000
 */
class PQInfo {
	int x;
	int y;
	int cnt;
	int num;

	public PQInfo(int x, int y, int cnt, int num) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.num = num;
	}
}

public class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M, K;
	static int[][] map;
	static int[][][] visited;
	static boolean isAble;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visited = new int[N + 1][M + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j - 1) - '0';
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		PriorityQueue<PQInfo> pq = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);
		for (int i = K; i >= 0; i--)
			visited[1][1][i] = 1;

		pq.offer(new PQInfo(1, 1, 1, K));

		while (!pq.isEmpty()) {
			PQInfo p = pq.poll();
			int x = p.x;
			int y = p.y;
			int cnt = p.cnt;
			int num = p.num;
			if (x == N && y == M) {
				isAble = true;
				System.out.println(cnt);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 범위 밖이면 나가기
				if(!isInMap(nx,ny)) continue;
				//다음칸이 이동할 수 있는 공간이라면
				if (map[nx][ny] == 0) {
					// 현재 경로 + 1이 해당 좌표에 방문한 경로 수 보다 적을 경우
					if (cnt + 1 < visited[nx][ny][num]) {
						// 현재와 같거나 더 적게 벽을 부술 수 있다면 경로 수를 지금보다 작게 해야댐
						for (int j = num; j >= 0; j--) {
							visited[nx][ny][j] = Math.min(visited[nx][ny][j], cnt + 1);
						}
						pq.offer(new PQInfo(nx, ny, cnt + 1, num));
					}
				} else { // 다음칸이 이동할 수 없는 공간이라면
					// 벽을 부술 수 있는 칸이 남았다면
					if (num > 0) {
						// 현재 경로 + 1이 해당 좌표에 방문한 경로 수 보다 적을 경우
						if (cnt + 1 < visited[nx][ny][num - 1]) {
							// 현재와 같거나 더 적게 벽을 부술 수 있다면 경로 수를 지금보다 작게 해야댐
							for (int j = num - 1; j >= 0; j--) {
								visited[nx][ny][j] = Math.min(visited[nx][ny][j], cnt + 1);
							}
							pq.offer(new PQInfo(nx, ny, cnt + 1, num - 1));
						}
					}
				}
			}
		}
		if (!isAble) {
			System.out.println(-1);
		}
	}

	static boolean isInMap(int x, int y) {
		if(x>0 && x<=N && y>0 && y<=M) return true;
		return false;
	}
}

/**
 *
 * 6 4 1
 * 0100
 * 1110
 * 1000
 * 0000
 * 0111
 * 0000
 *
 * q.offer(new int[]{1,1,1,1}) -> x,y좌표, 경로 수, 부술 수 있는 벽의 개수
 *
 * q.offer(new int[]{2,1,2,0}
 * q.offer(new int[]{1,2,2,0}
 * 방문하려면 경로 수가 적거나, 부술 수 있는 벽의 개수가 더 많으면됨 -> 부술 수 있는 벽의 개수 파악 어떻게
 */