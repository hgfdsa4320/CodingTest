import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[] wx = {-2, -1, -1, -1, 0, 1, 1, 1, 2};
	static int[] wy = {0, -1, 0, 1, -2, -1, 0, 1, 0};
	static double[] amount = {0.02, 0.1, 0.07, 0.01, 0.05, 0.1, 0.07, 0.01, 0.02};
	static double[][] map;
	static int N;
	static double answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new double[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[N / 2 + 1][N / 2 + 1] = true;
		tornado(N / 2 + 1, N / 2 , 0);


		System.out.println((int)answer);
	}

	static void tornado(int x, int y, int d) {
		visited[x][y] = true;

		wind(x, y, d);

		int nextD = (d + 1) % 4;
		int nx = x + dx[nextD];
		int ny = y + dy[nextD];
		if (nx > 0 && nx <= N && ny > 0 && ny <= N && !visited[nx][ny]) {
			tornado(nx, ny, nextD);
		} else {
			nx = x + dx[d];
			ny = y + dy[d];
			if (nx > 0 && nx <= N && ny > 0 && ny <= N && !visited[nx][ny]) {
				tornado(nx, ny, d);
			}
		}

	}


	static void wind(int x, int y, int d) {

		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int dx = wx[i];
			int dy = wy[i];
			for (int j = 0; j < d; j++) {
				int tmp = dx;
				dx = -dy;
				dy = tmp;
			}

			int nx = x + dx;
			int ny = y + dy;

			if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
				int sand = (int)(map[x][y] * amount[i]);
				map[nx][ny] += sand;
				sum += sand;
			} else {
				int sand = (int)(map[x][y] * amount[i]);
				sum += sand;
				answer += sand;
			}
		}
		int dx = 0;
		int dy = -1;
		for (int j = 0; j < d; j++) {
			int tmp = dx;
			dx = -dy;
			dy = tmp;
		}
		int nx = x + dx;
		int ny = y + dy;
		if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
			map[nx][ny] += map[x][y] - sum;
		} else {
			answer += map[x][y] - sum;
		}
	}

}