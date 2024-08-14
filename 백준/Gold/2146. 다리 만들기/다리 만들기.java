import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * bfs로 섬의 개수 파악 후
 * int[][] map 지도에 섬의 넘버로 작성
 * ex 1번섬은 1, 2범섬은 2
 *
 *
 * int[][] point => 제일 왼쪽, 제일 위 : 해당 섬의 대표 좌표를 기록해놓는다 -> 배열에
 *
 * 1. answer = Interger.MAX_VALUE로 초기화
 * 2. int num = 1 => 섬범호
 * for문 돌면서 방문안했고, 거기가 1이라면 -> num값 넣어줌(섬범호 각인)
 * 3. 모든 섬 간의 길이를 구하는 findDistance(int num1,int num2)-> 최솟값 찾기
 *
 */
public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, num, answer;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					//bfs로 이어져 있는 섬 같은 번호
					map[i][j] = num;
					checkLand(i, j);
					num++;
				}
			}
		}

		num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == num) {
					visited = new boolean[N][N];
					answer = Math.min(answer, findDistance(i, j));
					num++;
				}
			}
		}
		System.out.println(answer);

	}

	static void checkLand(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		while (!q.isEmpty()) {
			int[] p = q.poll();
			x = p[0];
			y = p[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isInMap(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
					map[nx][ny] = num;
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}

	static int findDistance(int x, int y) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		visited[x][y] = true;
		pq.offer(new int[] {x, y, 0});
		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			x = p[0];
			y = p[1];
			int cnt = p[2];
			if (map[x][y] != 0 && map[x][y] != num) {
				return cnt - 1;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isInMap(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (map[nx][ny] == num) {
						pq.offer(new int[] {nx, ny, cnt});
					} else{
						pq.offer(new int[] {nx, ny, cnt + 1});
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	static boolean isInMap(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<N) return true;
		return false;
	}
}