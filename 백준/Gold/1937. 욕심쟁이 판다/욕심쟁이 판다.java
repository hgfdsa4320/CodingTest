import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int[][] res;
	static int answer = 0;
	static boolean[][] visited;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		map = new int[n][n];
		res = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				pq.add(new int[] { i, j, map[i][j] });
			}
		}
		while (!pq.isEmpty()) {
			int x = pq.peek()[0];
			int y = pq.peek()[1];
			int num = pq.poll()[2];
			if (!visited[x][y]) {
				res[x][y] = dfs(x, y);
				answer = Math.max(answer, res[x][y]);
			}
		}
		System.out.println(answer+1);
	}

	static int dfs(int x, int y) {
		if (visited[x][y]) {
			return res[x][y];
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] < map[x][y]) {
				res[x][y] = Math.max(res[x][y], res[nx][ny] + 1);
			}
		}
		visited[x][y] = true;
		return res[x][y];
	}
}