import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 지도를 나타내는 이차원 배열 map을 만든다.
 * 3차원 배열로 지도에 {방향, 최소 거울 수}를 만든다.
 * bfs를 이용하여 최소 거울의 개수를 구한다.
 * PriorityQueue(거울수를 기준으로 한)에 들어가는 값 현재 좌표(x,y), 방향, 최소 거울 수
 * 우선순위큐가 비어있지 않는 한 계속하기
 */
class QueueInput{
	int x;
	int y;
	int d;
	int cnt;
	public QueueInput(int x, int y, int d, int cnt) {
		this.x=x;
		this.y=y;
		this.d=d;
		this.cnt = cnt;
	}

	public String toString() {
		return x + " " + y + " " + d + " " + cnt;
	}
}
public class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int W, H, sx, sy;
	static char[][] map; // 지도
	static int[][][] arr; // 지도 좌표에서의 방향과, 최소 거울 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		arr = new int[H][W][2];
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
				arr[i][j][1] = Integer.MAX_VALUE;
				if (map[i][j] == 'C') {
					sx = i;
					sy = j;
				}
			}
		}
		System.out.println(findNum());
	}

	static int findNum() {
		PriorityQueue<QueueInput> pq = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);
		for (int i = 0; i < 4; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != '*') {
				arr[nx][ny][0] = i;
				arr[nx][ny][1] = 0;
				pq.offer(new QueueInput(nx, ny, i, 0));
			}
		}

		while (!pq.isEmpty()) {
			QueueInput q = pq.poll();
			int x = q.x;
			int y = q.y;
			int d = q.d;
			int cnt = q.cnt;
			if (map[x][y] == 'C' && (x != sx || y != sy)) { // 레이저가 목적지에 도달했다면
				return cnt;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != '*') {
					if (i == d) {
						if (cnt <= arr[nx][ny][1]) {
							if(arr[nx][ny][0]==i && arr[nx][ny][1]==cnt) continue;
							arr[nx][ny][0] = i;
							arr[nx][ny][1] = cnt;
							pq.offer(new QueueInput(nx, ny, i, cnt));
						}
					} else {
						if (cnt < arr[nx][ny][1]) {
							arr[nx][ny][0] = i;
							arr[nx][ny][1] = cnt + 1;
							pq.offer(new QueueInput(nx, ny, i, cnt + 1));
						}
					}
				}
			}
		}
		return -1;
	}
}