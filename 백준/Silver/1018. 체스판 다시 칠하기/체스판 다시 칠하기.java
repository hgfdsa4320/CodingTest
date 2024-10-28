import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class QI{
	int x;
	int y;
	char now;

	public QI(int x, int y, char now) {
		this.x=x;
		this.y=y;
		this.now = now;
	}
}
public class Main {
	static int N, M, answer;
	static char[][] map, arr1, arr2;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static void setArr() {
		Queue<QI> q = new LinkedList<>();
		q.offer(new QI(0, 0, 'W'));
		while (!q.isEmpty()) {
			QI qi = q.poll();
			int x = qi.x;
			int y = qi.y;
			char now = qi.now;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isInMap(nx, ny) && arr1[nx][ny] == '\0') {
					arr1[nx][ny] = now == 'W' ? 'B' : 'W';
					q.offer(new QI(nx, ny, arr1[nx][ny]));
				}
			}
		}

		q = new LinkedList<>();
		q.offer(new QI(0, 0, 'B'));
		while (!q.isEmpty()) {
			QI qi = q.poll();
			int x = qi.x;
			int y = qi.y;
			char now = qi.now;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isInMap(nx, ny) && arr2[nx][ny] == '\0') {
					arr2[nx][ny] = now == 'W' ? 'B' : 'W';
					q.offer(new QI(nx, ny, arr2[nx][ny]));
				}
			}
		}
	}

	static boolean isInMap(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<M) return true;
		return false;
	}

	static void findRect(int x, int y) {
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if(map[i][j]!=arr1[i][j])
					cnt1++;
				if(map[i][j]!=arr2[i][j])
					cnt2++;
			}
		}
		int num = Math.min(cnt1, cnt2);
		answer = Math.min(answer, num);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		arr1 = new char[N][M];
		arr2 = new char[N][M];
		setArr();

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				findRect(i, j);
			}
		}
		System.out.println(answer);
	}

}