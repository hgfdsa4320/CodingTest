import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[][] map = new int[n + 1][n + 1];
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 2;
		}
		int l = Integer.parseInt(br.readLine());
		int d = 0;

		Queue<String[]> q = new LinkedList<>();
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String dir = st.nextToken();
			q.offer(new String[] { a, dir });
		}
		// 시작 위치
		int x = 1;
		int y = 1;
		map[x][y] = 1;
		int time = 0;
		Deque<int[]> dq = new LinkedList<>();
		dq.offer(new int[] {x,y});
		
		while (true) {
			time++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx <= 0 || nx > n || ny <= 0 || ny > n || map[nx][ny] == 1)
				break;
			if (map[nx][ny] == 0) {
				int[] tmp = dq.pollLast();
				int tx = tmp[0];
				int ty = tmp[1];
				map[tx][ty] = 0;
			}
			map[nx][ny] = 1;
			dq.offerFirst(new int[] {nx,ny});
			x = nx;
			y = ny;
			if (!q.isEmpty() && Integer.parseInt(q.peek()[0]) == time) {
				if (q.poll()[1].equals("D")) {
					d = d == 3 ? 0 : d + 1;
				} else {
					d = d == 0 ? 3 : d - 1;
				}
			}
		}
		System.out.println(time);

	}
}