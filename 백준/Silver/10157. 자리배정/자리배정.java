import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 우하좌상
 *
 */
public class Main {
	static int R, C;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[R + 1][C + 1];
		int K = Integer.parseInt(br.readLine());
		if (K > R * C) {
			System.out.println(0);
		} else {
			int x = 1;
			int y = 1;
			visited[x][y] = true;
			int d = 0;
			while (K > 1) {
				K--;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (isInMap(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					x = nx;
					y = ny;
				} else {
					K++;
					d = (d + 1) % 4;
				}
			}
			System.out.println(x+" "+y);
		}

	}

	static boolean isInMap(int x, int y) {
		if (x > 0 && x <= R && y > 0 && y <= C) {
			return true;
		}
		return false;
	}
}