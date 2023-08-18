import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };
	static int answer, n, m, d;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		answer = 0;
		map = new int[n + 1][m];
		visited = new boolean[m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findNum(0, 0);
		System.out.println(answer);

	}

	static void findNum(int cnt, int start) {

		if (cnt == 3) {
			int[][] tmp = deepCopy(map);
			int num = 0;// 잡은 적 수
			Queue<int[]> q = new LinkedList<>(); // {궁수 위치}
			for (int i = 0; i < m; i++) {
				if (visited[i])
					q.offer(new int[] { n, i, d });
			}
			Loop1: while (true) {
				for (int i = 0; i < 3; i++) {
					int[] archer = q.poll();
					if (archer[0] == 0) {
						answer = Math.max(answer, num);
						break Loop1;
					}
					Queue<int[]> findQ = new LinkedList<>();
					findQ.offer(archer);
					Loop2: while (!findQ.isEmpty()) {

						int[] temp = findQ.poll();
						int x = temp[0];
						int y = temp[1];
						int z = temp[2];
						for (int j = 0; j < 3; j++) {
							int nx = x + dx[j];
							int ny = y + dy[j];
							if (nx >= 0 && nx < archer[0] && ny >= 0 && ny < m && tmp[nx][ny] != 0) {
								if (tmp[nx][ny] == 1) {
									tmp[nx][ny] = 2;
									num++;
								}
								break Loop2;
							} else if (nx >= 0 && nx <= archer[0] && ny >= 0 && ny < m && tmp[nx][ny] == 0 && z > 1) {
								findQ.offer(new int[] { nx, ny, z - 1 });
							}
						}

					}
					
					q.offer(new int[] { archer[0] - 1, archer[1], archer[2] });
				}
				changeZero(tmp);
			}
			return;
		}
		for (int i = start; i < m; i++) {
			if (!visited[i]) {
				visited[i] = true;
				findNum(cnt + 1, i + 1);
				visited[i] = false;
			}
		}

	}

	static int[][] deepCopy(int[][] arr) {
		int[][] tmp = new int[arr.length][arr[0].length];
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}

	static void changeZero(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 2)
					arr[i][j] = 0;
			}
		}
	}

}