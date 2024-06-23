import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 쓰레기 통과 싫어함
 * 2. 쓰레기 옆을 지나가는 것도 싫음
 * S : 데이트 시작 장소, F : 꽃이 있는 위치, g = 쓰레기가 있는 위치, . = 깨끗한 칸
 * 형택이의 목표는 S에서 F까지 가는데, 쓰레기로 차있는 칸을 되도록이면 적게 지나가는 것이다.
 * 만약 되도록 적게 지나가는 경우의 수가 여러개라면, 쓰레기 옆을 지나가는 칸의 개수를 최소로 해서 지나려고 한다.
 * 만약 어떤 칸이 비어있는데, 인접한 칸에 쓰레기가 있으면 쓰레기 옆을 지나는 것이다. 그리고, S와 F는 세지 않는다.
 */
public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static char[][] forest;
	static int N, M, sx, sy, fx, fy;
	static int[] answer;
	static int[][][] count;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * 숲의 크기 -> 최대 2500
		 * 둘째 줄부터 숲의 지도가 주어진다. 숲의 지도는 S, F, g, . 만으로 이루어져 있다.
		 * S는 반드시 모서리에 위치해 있고, F는 모서리에 위치해있지 않다. 그리고 S와 F는 반드시 하나만 주어진다.
		 */
		StringTokenizer st = new StringTokenizer(br.readLine());
		cnt = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		forest = new char[N][M];
		count = new int[N][M][2];
		answer = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				Arrays.fill(count[i][j], Integer.MAX_VALUE);
				forest[i][j] = s.charAt(j);
				if (forest[i][j] == 'S') {
					sx = i;
					sy = j;
				} else if (forest[i][j] == 'F') {
					fx = i;
					fy = j;
				}
			}
		}
		findNum(sx, sy);
		System.out.println(answer[0] + " " + answer[1]);

	}

	static void findNum(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, 0, 0});
		count[x][y][0] = 0;
		count[x][y][1] = 0;

		while (!q.isEmpty()) {
			cnt++;
			int[] p = q.poll();
			x = p[0];
			y = p[1];

			int pass = p[2]; // 쓰레기 통과
			int side = p[3]; // 쓰레기 옆에 지나감
			// if (count[x][y][0] < pass || (count[x][y][0] == pass && count[x][y][1] <= side)) {
			// 	continue;
			// }
			if (x == fx && y == fy) {
				if (pass < answer[0]) {
					answer[0] = pass;
					answer[1] = side;
				} else if (pass == answer[0] && side < answer[1]) {
					answer[1] = side;
				}
				continue;
			}

			// 마지막이 꽃인지 확인
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isInMap(nx, ny)) {
					//그 위치가 쓰레기면
					if (forest[nx][ny] == 'g') {
						// 현재 쓰레기 통과 +1이 그 위치의 쓰레기 통과 횟수 보다 적을 경우
						if (pass + 1 < count[nx][ny][0]) {
							count[nx][ny][0] = pass + 1;
							count[nx][ny][1] = side;
							q.offer(new int[] {nx, ny, pass + 1, side});
						} else if (pass + 1 == count[nx][ny][0]) { // 같은 경우
							if (side < count[nx][ny][1]) {
								count[nx][ny][0] = pass + 1;
								count[nx][ny][1] = side;
								q.offer(new int[] {nx, ny, pass + 1, side});
							}
						}
					} else {//그 위치가 쓰레기가 아니면 -> 그 위치가 꽃인지도 확인해야됨
						if (pass < count[nx][ny][0]) {
							if (forest[nx][ny] != 'F') {
								count[nx][ny][0] = pass;
								count[nx][ny][1] = side + (isSideGarbage(nx, ny) ? 1 : 0);
								q.offer(new int[] {nx, ny, pass, side + (isSideGarbage(nx, ny) ? 1 : 0)});
							} else {
								count[nx][ny][0] = pass;
								count[nx][ny][1] = side;
								q.offer(new int[] {nx, ny, pass, side});
							}
						} else if (pass == count[nx][ny][0]) { // 같은 경우
							if (forest[nx][ny] != 'F') {
								int num = isSideGarbage(nx, ny) ? 1 : 0;
								if (side + num < count[nx][ny][1]) {
									count[nx][ny][0] = pass;
									count[nx][ny][1] = side + num;
									q.offer(new int[] {nx, ny, pass, side + num});
								}
							} else {
								if (side < count[nx][ny][1]) {
									count[nx][ny][0] = pass;
									count[nx][ny][1] = side;
									q.offer(new int[] {nx, ny, pass, side});
								}
							}

						}
					}
				}
			}
		}
	}

	static boolean isInMap(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}

	static boolean isSideGarbage(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isInMap(nx, ny) && forest[nx][ny] == 'g') {
				return true;
			}
		}
		return false;
	}
}