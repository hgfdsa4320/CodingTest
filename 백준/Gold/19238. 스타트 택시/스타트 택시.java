import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int[][] map;
	static int n, m, x, y;
	static boolean[][] visited;
	static Map<String, String> info;
	static int fuel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];
		info = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= m + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int px = Integer.parseInt(st.nextToken());
			int py = Integer.parseInt(st.nextToken());
			map[sx][sy] = i;
			map[px][py] = 1000 + i;
			info.put(sx + "," + sy, px + "," + py);

		}
		if (find()) {
			System.out.println(fuel);
		} else {
			System.out.println(-1);
		}
	}

	static boolean find() {
		boolean isChange = true;
		Loop1: while (m > 0 && isChange) {
			PriorityQueue<int[]> q = new PriorityQueue<>(
					(a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
			q.offer(new int[] { x, y, 0 });
			visited[x][y] = true;
			isChange = false;
			int idx = 0;
			while (!q.isEmpty()) {				
				int tx = q.peek()[0];
				int ty = q.peek()[1];
				int cnt = q.poll()[2];
				int dist = findDistance(x, y, tx, ty);
				if (info.containsKey(tx + "," + ty)) {
					fuel -= dist;
					
					String p = info.get(tx + "," + ty);
					int px = Integer.parseInt(p.split(",")[0]);
					int py = Integer.parseInt(p.split(",")[1]);
					dist = findDistance(tx, ty, px, py);
					
					if (fuel >= dist && dist != -1) {
						fuel += dist;
						m--;
						x = px;
						y = py;
						info.remove(tx + "," + ty);
						isChange = true;
						visited = new boolean[n + 1][n + 1];
						continue Loop1;
					} else {
						return false;
					}
				}
				
				if(idx<cnt) idx++;
				
				for (int i = 0; i < 4; i++) {
					int ntx = tx + dx[i];
					int nty = ty + dy[i];
					if (ntx > 0 && ntx <= n && nty > 0 && nty <= n && !visited[ntx][nty]) {
						if (map[ntx][nty] != 1) {
							visited[ntx][nty] = true;
							q.offer(new int[] { ntx, nty, cnt + 1 });	
						}
					}
				}
				
				
	

			}
		}
		if (m == 0)
			return true;
		return false;
	}

	static int findDistance(int sx, int sy, int px, int py) {
		boolean[][] checked = new boolean[n + 1][n + 1];
		checked[sx][sy] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sx, sy, 0 });
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.poll()[2];
			if (x == px && y == py)
				return cnt;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx > 0 && nx <= n && ny > 0 && ny <= n && !checked[nx][ny] && map[nx][ny] != 1) {
					checked[nx][ny] = true;
					q.offer(new int[] { nx, ny, cnt + 1 });
				}
			}
		}
		return -1;
	}
}