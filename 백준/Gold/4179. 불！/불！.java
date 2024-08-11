import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 얼마나 빨리 탈출? bfs?
 * 전에 방문한 곳은 다시 방문할 필요 x
 * Queue<Inf> -> x,y: 위치 , t: 시간
 * while문 안에 q가 비어있지 않는 동안 반복 -> 그때 탈출 할 수 있는 최소 시간
 * -> q에 계속 채워지므로 처음에 int size = q.size()로 하고 -> for문으로 반복
 * -> fireQ불이 탔는지
 * 시간이 지날때 불이 먼저 가고 그 다음에 사람 확인
 */

class Inf{
	int x;
	int y;
	public Inf(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int R, C;
	static boolean isOut;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		map = new char[R][C];
		Queue<Inf> fireQ = new LinkedList<>(); // 불을 담을 큐
		int sx = 0;
		int sy = 0;
		int fx = 0;
		int fy = 0;
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'J') {
					map[i][j] = '.';
					sx = i;
					sy = j;
				} else if (map[i][j] == 'F') {
					fx = i;
					fy = j;
					fireQ.offer(new Inf(fx, fy));
				}
			}
		}
		Queue<Inf> q = new LinkedList<>(); // 사람을 담을 큐
		q.offer(new Inf(sx, sy));
		visited[sx][sy] = true;


		int time = 1;
		while (true) {
			// 불부터 쭉 이동
			int size = fireQ.size();
			for (int i = 0; i < size; i++) {
				Inf inf = fireQ.poll();
				fx = inf.x;
				fy = inf.y;
				for (int j = 0; j < 4; j++) {
					int nfx = fx + dx[j];
					int nfy = fy + dy[j];
					// 불이 다음 공간이 미로안에 위치하고 지나갈 수 있는 공간이면
					if (isInMap(nfx, nfy) && map[nfx][nfy] == '.') {
						fireQ.offer(new Inf(nfx, nfy));
						map[nfx][nfy] = 'F';
					}
				}
			}
			size = q.size();
			for (int i = 0; i < size; i++) {
				Inf inf = q.poll();
				sx = inf.x;
				sy = inf.y;
				for (int j = 0; j < 4; j++) {
					int nsx = sx + dx[j];
					int nsy = sy + dy[j];
					if (!isInMap(nsx, nsy)) {
						isOut = true;
						break;
					}
					if (map[nsx][nsy] == '.' && !visited[nsx][nsy]) {
						q.offer(new Inf(nsx, nsy));
						visited[nsx][nsy] = true;
					}
				}
				if(isOut) break;
			}
			if(isOut) break;
			time++;
			if(q.size()==0) break;
		}
		if (isOut) {
			System.out.println(time);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}

	static boolean isInMap(int x, int y) {
		if(x>=0 && x<R && y>=0 && y<C)
			return true;
		return false;
	}
}