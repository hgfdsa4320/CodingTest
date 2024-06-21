import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {1, 0, -1, 0, -2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {0, 1, 0, -1, -1, 1, -2, 2, -2, 2, -1, 1};
	static int[][][] arr; // {x,y}좌표에 {cnt,남은 이동 횟수}
	static int K, W, H;
	static int[][] map;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W][2];
		map = new int[H][W];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j][0] = Integer.MAX_VALUE;
			}
		}
		arr[0][0][0] = 0;
		arr[0][0][1] = K;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 0, K});

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];
			int cnt = p[2];
			if (x == H - 1 && y == W - 1) {
				answer = Math.min(answer, cnt);
			}
			int left = p[3];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 움직일 수 있고 이동거리가 더 작아지거나, 남은 K수가 더 커져야됨
				if (isInMap(nx, ny) && map[nx][ny]==0 && (arr[nx][ny][0] > cnt + 1 || arr[nx][ny][1] < left)) {
					arr[nx][ny][0] = cnt + 1;
					arr[nx][ny][1] = left;
					q.offer(new int[] {nx, ny, cnt + 1, left});
				}
			}
			if (left > 0) {
				for (int i = 4; i < 12; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (isInMap(nx, ny) && map[nx][ny]==0 && (arr[nx][ny][0] > cnt + 1 || arr[nx][ny][1] < left - 1)) {
						arr[nx][ny][0] = cnt + 1;
						arr[nx][ny][1] = left - 1;
						q.offer(new int[] {nx, ny, cnt + 1, left - 1});
					}
				}
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	static boolean isInMap(int x, int y) {
		if (x >= 0 && x < H && y >= 0 && y < W) {
			return true;
		}
		return false;
	}
}