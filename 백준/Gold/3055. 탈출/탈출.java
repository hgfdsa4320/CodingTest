import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int answer = Integer.MAX_VALUE;
	static Queue<int[]> q;
	static int r, c, x, y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		q = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S') {
					x = i;
					y = j;
				} else if (map[i][j] == '*') {
					q.offer(new int[] { 0, i, j, 0 });
				}
			}
		}
		int time = findTime();
		if (time == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(time);
		}
	}

	static int findTime() {
		boolean[][] visited = new boolean[r][c];
		visited[x][y] = true;
		q.offer(new int[] { 1, x, y, 0 });

		while (!q.isEmpty()) {
			int kind = q.peek()[0];
			if (kind == 0) {
				int wx = q.peek()[1];
				int wy = q.peek()[2];
				int time = q.poll()[3];
				for (int i = 0; i < 4; i++) {
					int wnx = wx + dx[i];
					int wny = wy + dy[i];
					if (wnx >= 0 && wnx < r && wny >= 0 && wny < c && map[wnx][wny] == '.') {
						map[wnx][wny] = '*';
						q.offer(new int[] { 0, wnx, wny, time + 1 });
					}
				}
			} else {
				int gx = q.peek()[1];
				int gy = q.peek()[2];
				int time = q.poll()[3];
				if (map[gx][gy] == 'D') {
					return time;
				}
				for (int i = 0; i < 4; i++) {
					int gnx = gx + dx[i];
					int gny = gy + dy[i];
					if (gnx >= 0 && gnx < r && gny >= 0 && gny < c && !visited[gnx][gny]) {
						if(map[gnx][gny] == '.') {
							visited[gnx][gny] = true;
							q.offer(new int[] { 1, gnx, gny, time + 1 });	
						}else if(map[gnx][gny] == 'D') {
							return time+1;
						}
						
					}
				}
			}
		}
		return -1;
	}
}