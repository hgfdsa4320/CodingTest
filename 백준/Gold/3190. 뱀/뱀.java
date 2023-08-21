import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1 }; // 우하좌상
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}
		int l = Integer.parseInt(br.readLine());
		PriorityQueue<String[]> pq = new PriorityQueue<>((a,b)->Integer.parseInt(a[0])-Integer.parseInt(b[0]));
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			pq.offer(new String[] {String.valueOf(x),c});
		}
		int t = 0;
		int d = 0;
		int x = 1;
		int y = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		map[x][y] = 2;
		while (true) {
			t++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx <= 0 || nx > n || ny <= 0 || ny > n || map[nx][ny] == 2) {
				break;
			} else if (map[nx][ny] == 1) {
				map[nx][ny] = 2;
				x = nx;
				y = ny;
				q.offer(new int[] {nx,ny});
			} else {
				int[] place = q.poll();
				map[place[0]][place[1]] = 0;
				q.offer(new int[] {nx,ny});
				map[nx][ny]=2;
				x = nx;
				y = ny;
			}
			if(!pq.isEmpty() && t==Integer.parseInt(pq.peek()[0])) {
				String[] tmp = pq.poll();
				if(tmp[1].equals("L")) {
					d = d==0?3:d-1;
				}else {
					d = (d+1)%4;
				}
			}
		}
		System.out.println(t);
	}
}