import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class PP{
	int x;
	int y;

	public PP(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return x + " " + y;
	}
}
class QIn{
	int x;
	int y;
	int time;

	public QIn(int x, int y, int time) {
		this.x=x;
		this.y=y;
		this.time = time;
	}
}
public class Main {
	static int N, M, answer;
	static int[] dx = {1, -1, 0, 0,};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static int[] arr;
	static List<PP> enableVirusList;
	static void findNum(int cnt,int start) {
		if (cnt == M) {
			answer = Math.min(answer,findTime());
			return;
		}
		for (int i = start; i < enableVirusList.size(); i++) {
			arr[cnt] = i;
			findNum(cnt + 1, i + 1);
		}
	}

	static int findTime() {
		Queue<QIn> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < arr.length; i++) {
			PP place = enableVirusList.get(arr[i]);
			visited[place.x][place.y] = true;
			q.offer(new QIn(place.x, place.y, 0));
		}
		int time = 0;
		while (!q.isEmpty()) {
			QIn p = q.poll();
			int x=  p.x;
			int y = p.y;
			int now = p.time;
			time = Math.max(time, now);

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 격자 밖이거나 방문했거나 벽이라면
				if (!isInMap(nx, ny) || visited[nx][ny] || map[nx][ny] == 1)
					continue;

				visited[nx][ny] = true;
				q.offer(new QIn(nx, ny, now + 1));
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					if (map[i][j] == 0 || map[i][j] == 2) {
						return Integer.MAX_VALUE;
					}
				}
			}
		}
		return time;
	}

	static boolean isInMap(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<N)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		arr = new int[M];
		enableVirusList = new ArrayList<>();
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					enableVirusList.add(new PP(i, j));
				}
			}
		}
		findNum(0,0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}