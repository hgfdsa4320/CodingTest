import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		System.out.println(bfs(0, 0,1));
	}

	static int bfs(int x, int y,int cnt) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new int[] {x, y, cnt});
		while (!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			cnt = q.poll()[2];
			if (x == n - 1 && y == m - 1) {
				return cnt;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny, cnt + 1});
				}
			}
		}
		return -1;
	}

}