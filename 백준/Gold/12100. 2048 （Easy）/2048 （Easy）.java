import java.io.*;
import java.util.*;

public class Main {
	static int answer, n;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		move(map, 0);
		System.out.println(answer);
	}

	static void move(int[][] arr, int cnt) {
		if (cnt == 5) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					answer = Math.max(answer, arr[i][j]);
				}
			}
			return;
		}
		// 왼쪽
		int[][] tmp = new int[n][n];
		for (int i = 0; i < n; i++) {
			Queue<Integer> q = new LinkedList<>();
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0)
					q.offer(arr[i][j]);
			}
			int idx = 0;
			while (!q.isEmpty()) {
				int a = q.poll();
				if (!q.isEmpty() && a == q.peek()) {
					q.poll();
					tmp[i][idx++] = a * 2;
				} else {
					tmp[i][idx++] = a;
				}
			}
		}
		move(tmp, cnt + 1);

		// 위쪽
		tmp = new int[n][n];
		for (int j = 0; j < n; j++) {
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				if (arr[i][j] != 0)
					q.offer(arr[i][j]);
			}
			int idx = 0;
			while (!q.isEmpty()) {
				int a = q.poll();
				if (!q.isEmpty() && a == q.peek()) {
					q.poll();
					tmp[idx++][j] = a * 2;
				} else {
					tmp[idx++][j] = a;
				}
			}
		}
		move(tmp, cnt + 1);

		// 오른쪽
		tmp = new int[n][n];
		for (int i = 0; i < n; i++) {
			Queue<Integer> q = new LinkedList<>();
			for (int j = n - 1; j >= 0; j--) {
				if (arr[i][j] != 0)
					q.offer(arr[i][j]);
			}
			int idx = n - 1;
			while (!q.isEmpty()) {
				int a = q.poll();
				if (!q.isEmpty() && a == q.peek()) {
					q.poll();
					tmp[i][idx--] = a * 2;
				} else {
					tmp[i][idx--] = a;
				}
			}
		}
		move(tmp, cnt + 1);

		// 아래쪽
		tmp = new int[n][n];
		for (int j = 0; j < n; j++) {
			Queue<Integer> q = new LinkedList<>();
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i][j] != 0)
					q.offer(arr[i][j]);
			}
			int idx = n - 1;
			while (!q.isEmpty()) {
				int a = q.poll();
				if (!q.isEmpty() && a == q.peek()) {
					q.poll();
					tmp[idx--][j] = a * 2;
				} else {
					tmp[idx--][j] = a;
				}
			}
		}
		move(tmp, cnt + 1);

	}

	static int[][] copyArr(int[][] arr) {
		int[][] tmp = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}
}