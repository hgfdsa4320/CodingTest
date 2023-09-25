import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[][] map;
	static boolean[][] visited;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[m][n];
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int teamW = 0;
		int teamB = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					int n = bfs(i, j, map[i][j]);
					if(map[i][j]=='W') {
						teamW+=Math.pow(n,2);
					}else {
						teamB+=Math.pow(n, 2);
					}
				}
			}
		}
		System.out.println(teamW+" "+teamB);
	}

	static int bfs(int x, int y, char c) {
		int cnt = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			x = q.peek()[0];
			y = q.poll()[1];
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && nx<m && ny>=0 && ny<n && map[nx][ny]==c && !visited[nx][ny]) {
					cnt++;
					q.offer(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}
		}
		return cnt;
	}
}