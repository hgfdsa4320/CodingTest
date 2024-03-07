import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Info{
	int from;
	int to;
	int dist;

	public Info(int from, int to, int dist) {
		this.from = from;
		this.to = to;
		this.dist = dist;
	}
}
public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 1;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(i, j, cnt++);
				}
			}
		}

		parent = new int[cnt];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						int dist = 0;
						if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
						while (true) {
							if (map[nx][ny] != 0){
								if (map[nx][ny] != map[i][j] && dist >= 2) {
									pq.offer(new Info(map[i][j], map[nx][ny], dist));
								}
								break;
							} else {
								nx += dx[k];
								ny += dy[k];
								dist++;
								if (nx < 0 || nx >= N || ny < 0 || ny >= M)
									break;
							}
						}
					}
				}

			}
		}
		int ans = 0;
		while (!pq.isEmpty()) {
			Info p = pq.poll();
			if (find(p.from) == find(p.to)) {
				continue;
			}
			union(p.from, p.to);

			ans += p.dist;
		}
		boolean isConnected = true;
		for (int i = 1; i < parent.length; i++) {
			if (find(i) != 1) {
				isConnected = false;
			}
		}
		if (isConnected) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}

	}

	static void dfs(int x, int y, int cnt) {
		visited[x][y] = true;
		map[x][y] = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny, cnt);
				}
			}
		}
	}

	static void union(int a, int b) {
		int A = find(a);
		int B = find(b);

		if(A==B) return;

		if (A < B) {
			parent[B] = A;
		} else {
			parent[A] = B;
		}
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		}

		return parent[a] = find(parent[a]);
	}
}