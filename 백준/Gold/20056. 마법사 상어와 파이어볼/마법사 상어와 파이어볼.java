import java.io.*;
import java.util.*;

public class Main {
	static class FireBall {
		int r;
		int c;
		int m;
		int s;
		int d;
		int cnt;

		public FireBall(int r, int c, int m, int s, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "FireBall{" + "r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + ", cnt=" + cnt + '}';
		}
	}

	static int N, M, K;
	static int[][] map;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static Queue<FireBall> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			q.offer(new FireBall(r, c, m, s, d, 1));
		}
		while (K > 0) {
			FireBall[][] tmpMap = new FireBall[N + 1][N + 1];
			while (!q.isEmpty()) {
				FireBall f = q.poll();
				int r = f.r;
				int c = f.c;
				int m = f.m;
				int s = f.s;
				int d = f.d;
				for (int i = 0; i < s; i++) {
					r += dx[d];
					c += dy[d];
					if (d != 2 && d != 6) {
						if (r <= 0)
							r = N;
						if (r > N)
							r = 1;
					}
					if (d != 0 && d != 4) {
						if (c <= 0)
							c = N;
						if (c > N)
							c = 1;
					}

				}
				if (tmpMap[r][c] == null) {
					tmpMap[r][c] = new FireBall(r, c, m, s, d, 1);
				} else {
					tmpMap[r][c].m += m;
					tmpMap[r][c].s += s;
					tmpMap[r][c].cnt++;
					if (tmpMap[r][c].d % 2 != d % 2) {
						tmpMap[r][c].d = 8; // 8이면 방향 1,3,5,7
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (tmpMap[i][j] != null) {
						FireBall f = tmpMap[i][j];
						int r = f.r;
						int c = f.c;
						int m = f.m;
						int s = f.s;
						int d = f.d;
						int cnt = f.cnt;
						if (cnt > 1) {
							if (m < 5)
								continue;
							if (d == 8) {
								q.offer(new FireBall(r, c, m / 5, s / cnt, 1, 1));
								q.offer(new FireBall(r, c, m / 5, s / cnt, 3, 1));
								q.offer(new FireBall(r, c, m / 5, s / cnt, 5, 1));
								q.offer(new FireBall(r, c, m / 5, s / cnt, 7, 1));
							} else {
								q.offer(new FireBall(r, c, m / 5, s / cnt, 0, 1));
								q.offer(new FireBall(r, c, m / 5, s / cnt, 2, 1));
								q.offer(new FireBall(r, c, m / 5, s / cnt, 4, 1));
								q.offer(new FireBall(r, c, m / 5, s / cnt, 6, 1));
							}
						} else {
							q.offer(new FireBall(r, c, m, s, d, 1));
						}
					}
				}
			}
			K--;
		}
		int answer = 0;
		while (!q.isEmpty()) {
			answer += q.poll().m;
		}
		System.out.println(answer);
	}
}