import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][][] visited;
	static int[][] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			map = new int[n][n];
			res = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(res[i], Integer.MAX_VALUE);
			}
			visited = new boolean[n][n][4];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
			pq.offer(new int[] { 0, 0, map[0][0] });
			for (int i = 0; i < 4; i++) {
				visited[0][0][i] = true;
			}
			res[0][0] = map[0][0];
			while (!pq.isEmpty()) {
				int x = pq.peek()[0];
				int y = pq.peek()[1];
				int value = pq.poll()[2];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny][i]) {
						visited[nx][ny][i] = true;
						res[nx][ny] = Math.min(res[nx][ny], value + map[nx][ny]);
						pq.offer(new int[] {nx,ny,res[nx][ny]});
					}
				}
			}
			
			System.out.println("Problem "+tc++ + ": "+res[n-1][n-1]);
		}
	}
}