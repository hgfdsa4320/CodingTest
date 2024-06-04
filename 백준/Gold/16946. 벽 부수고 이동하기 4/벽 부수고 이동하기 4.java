import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Po{
	int x;
	int y;
	public Po(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[][] visited;
	static int count;
	static int[][] map;
	static int[][] cntMap;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		visited = new int[N][M];
		cntMap = new int[N][M];
		count = 1;
		findMap();

		int[][] answer = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					Set<Integer> tmp = new HashSet<>();
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (isInMap(nx, ny) && cntMap[nx][ny] > 0 && !tmp.contains(visited[nx][ny])) {
							answer[i][j] += cntMap[nx][ny];
							tmp.add(visited[nx][ny]);
						}
					}
					answer[i][j]++;
					answer[i][j] %= 10;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(answer[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void findMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && visited[i][j] == 0) {
					bfs(i, j);
					count++;
				}
			}
		}
	}

	static void bfs(int x, int y) {
		Queue<Po> q = new LinkedList<>();
		Queue<Po> storeQ = new LinkedList<>();
		q.offer(new Po(x, y));
		storeQ.offer(new Po(x, y));
		visited[x][y] = count;

		while (!q.isEmpty()) {
			Po p = q.poll();
			x = p.x;
			y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isInMap(nx, ny) && map[nx][ny] == 0 && visited[nx][ny] == 0) {
					visited[nx][ny] = count;
					q.offer(new Po(nx, ny));
					storeQ.offer(new Po(nx, ny));
				}
			}
		}
		int cnt = storeQ.size();
		while (!storeQ.isEmpty()) {
			Po p = storeQ.poll();
			cntMap[p.x][p.y] = cnt;
		}
	}

	static boolean isInMap(int nx, int ny) {
		if(nx>=0 && nx<N && ny>=0 && ny<M) return true;
		return false;
	}
}