import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][][] map;
	static boolean[][][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1][3];
		visited = new boolean[n + 1][m + 1][3];

		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j + 1][0] = s.charAt(j) - '0';
			}
		}
		visited[1][1][1] = true;
		map[1][1][1]=1;
		map[1][1][2]=1;
		bfs();
		if(visited[n][m][1]) {
			answer = map[n][m][1];
		}
		if(visited[n][m][2]) {
			answer = Math.min(answer, map[n][m][2]);
		}
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 1, 1, 1 });
		visited[1][1][1] = true;
		visited[1][1][2] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			int wall = tmp[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
					if (map[nx][ny][0] == 0 && !visited[nx][ny][wall]) {
						visited[nx][ny][wall] = true;
						map[nx][ny][wall] = map[x][y][wall]+1;
						q.offer(new int[] {nx,ny,wall});
					}else {
						if(wall==1 && !visited[nx][ny][wall+1]) {
							visited[nx][ny][wall+1] = true;
							map[nx][ny][wall+1] = map[x][y][wall]+1;
							q.offer(new int[] {nx,ny,wall+1});
						}
					}
				}
			}
		}
		
	}
}