import java.io.*;
import java.util.*;

public class Main {
	static int answer, n;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		findNum(1, 2, 0);
		System.out.println(answer);
	}

	static void findNum(int x, int y, int d) {
		if (x == n && y == n) {
			answer++;
			return;
		}
		if (d == 0) {
			if (y + 1 <= n && map[x][y + 1] != 1) {
				findNum(x, y + 1, d);
			}
			if (x + 1 <= n && y + 1 <= n && map[x + 1][y] != 1 && map[x][y + 1] != 1 && map[x + 1][y + 1] != 1) {
				findNum(x + 1, y + 1, 1);
			}
		} else if (d == 1) {
			if (y + 1 <= n && map[x][y + 1] != 1) {
				findNum(x, y + 1, 0);
			}
			if (x + 1 <= n && y + 1 <= n && map[x + 1][y] != 1 && map[x][y + 1] != 1 && map[x + 1][y + 1] != 1) {
				findNum(x + 1, y + 1, 1);
			}
			if (x + 1 <= n && map[x + 1][y] != 1) {
				findNum(x + 1, y, 2);
			}
		} else {
			if (x + 1 <= n && y + 1 <= n && map[x + 1][y] != 1 && map[x][y + 1] != 1 && map[x + 1][y + 1] != 1) {
				findNum(x + 1, y + 1, 1);
			}
			if (x + 1 <= n && map[x + 1][y] != 1) {
				findNum(x + 1, y, 2);
			}
		}
	}

}