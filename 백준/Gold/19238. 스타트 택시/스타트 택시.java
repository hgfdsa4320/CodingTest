import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int[][] map;
	static int n, m, x, y;
	static boolean[][] visited;
	static Map<String, String> info;
	static int fuel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];
		info = new HashMap<>(); //  map에 {출발 위치, 목적지} 순으로 넣어 놓음 ex) {"1,2","2,3"}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= m + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int px = Integer.parseInt(st.nextToken());
			int py = Integer.parseInt(st.nextToken());
			info.put(sx + "," + sy, px + "," + py);
		}
		if (find()) {
			System.out.println(fuel);
		} else {
			System.out.println(-1);
		}
	}

	static boolean find() {
		boolean isChange = true;
		Loop1: while (m > 0 && isChange) { //태울 사람이 있고(m==태워야 되는 사람 수),변화가 있을 동안만 실행
			//{x,y,dist}-> 좌표와 거리가 들어가서, 현재 위치에서 거리-> x좌표-> y좌표 순으로 정렬
			PriorityQueue<int[]> q = new PriorityQueue<>(
					(a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
			q.offer(new int[] { x, y, 0 });
			visited[x][y] = true;
			isChange = false;
			while (!q.isEmpty()) {				
				int tx = q.peek()[0]; //현재 x좌표
				int ty = q.peek()[1]; //현재 y좌표 
				int cnt = q.poll()[2]; // 거리
				if (info.containsKey(tx + "," + ty)) { //tx,ty 좌표에 택시를 탈 사람이 있으면
					int dist = findDistance(x, y, tx, ty); // 현재 위치에서 사람이 있는 위치 까지 거리 구함
					fuel -= dist; //연료에서 거리 빼줌
					
					String p = info.get(tx + "," + ty); // 택시탄 사람의 목적지 위치 가져옴
					int px = Integer.parseInt(p.split(",")[0]);
					int py = Integer.parseInt(p.split(",")[1]);
					dist = findDistance(tx, ty, px, py); // 현재 사람 위치에서 목적지까지 거리 구함
					
					if (fuel >= dist && dist != -1) { // 연료가 부족하거나 가지 못하면 return false
						fuel += dist; //갈 수 있으면 연료 채워주고 
						m--; // 사람 한명 빼주고
						x = px; //택시의 현재 위치를 목적지 위치로 바꿔줌
						y = py;
						info.remove(tx + "," + ty); // 택시 내린 사람 info에서 지워줌
						isChange = true; //변화가 있으면 true로 바꿔줌
						visited = new boolean[n + 1][n + 1]; // 방문 배열 초기화
						continue Loop1; // 위치가 변화했으므로 첨부터 다시 시작
					} else {
						return false; 
					}
				}
				
				
				for (int i = 0; i < 4; i++) {
					int ntx = tx + dx[i];
					int nty = ty + dy[i];
					if (ntx > 0 && ntx <= n && nty > 0 && nty <= n && !visited[ntx][nty]) {
						if (map[ntx][nty] != 1) {
							visited[ntx][nty] = true;
							q.offer(new int[] { ntx, nty, cnt + 1 });	
						}
					}
				}
			}
		}
		if (m == 0)
			return true;
		return false;
	}

	// 두 점 사이의 최단 거리를 찾는 함수, 이동할 수 없으면 -1 return
	static int findDistance(int sx, int sy, int px, int py) { 
		boolean[][] checked = new boolean[n + 1][n + 1];
		checked[sx][sy] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sx, sy, 0 });
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.poll()[2];
			if (x == px && y == py)
				return cnt;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx > 0 && nx <= n && ny > 0 && ny <= n && !checked[nx][ny] && map[nx][ny] != 1) {
					checked[nx][ny] = true;
					q.offer(new int[] { nx, ny, cnt + 1 });
				}
			}
		}
		return -1;
	}
}