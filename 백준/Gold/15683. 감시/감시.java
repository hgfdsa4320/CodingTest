import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int n, m, answer;
	static Map<Integer, int[][]> cctvMap; // 번호별 방향
	static List<int[]> cctv;
	static int[] cctvDir;
	static boolean[][] cctvDirect;
	static Set<String> set;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		map = new int[n][m];
		cctvMap = new HashMap<>();
		cctvMap.put(1, new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }); // 우
		cctvMap.put(2, new int[][] { { 0, 1, 0, -1 }, { 1, 0, -1, 0 }, { 0, 1, 0, -1 }, { 1, 0, -1, 0 } }); // 좌우
		cctvMap.put(3, new int[][] { { -1, 0, 0, 1 }, { 1, 0, 0, 1 }, { -1, 0, 0, -1 }, { 1, 0, 0, -1 } }); // 상우
		cctvMap.put(4, new int[][] { { 0, -1, -1, 0, 0, 1 }, { 1, 0, -1, 0, 0, 1 }, { 0, -1, 1, 0, 0, 1 },
				{ 0, -1, -1, 0, 1, 0 } }); // 좌상우
		cctvMap.put(5, new int[][] { { 0, 1, -1, 0, 1, 0, 0, -1 }, { 0, 1, -1, 0, 1, 0, 0, -1 },
				{ 0, 1, -1, 0, 1, 0, 0, -1 }, { 0, 1, -1, 0, 1, 0, 0, -1 } }); // 전방향

		cctv = new ArrayList<>(); // cctv가 있는 곳의 좌표를 집어 넣음

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctv.add(new int[] { i, j });
				}
			}
		}
		cctvDirect = new boolean[cctv.size()][4];
		cctvDir = new int[cctv.size()];
		set = new HashSet<>();
		int[] arr = new int[cctv.size()];
		dfs(0, arr);
		System.out.println(answer);
	}

	static void dfs(int idx, int[] arr) {
		if (idx == cctv.size()) {
			int[][] tmp = deepCopy(map);
			visited = new boolean[n][n];
			answer = Math.min(answer,findNum(tmp, arr));
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (!cctvDirect[idx][i]) {
				cctvDirect[idx][i] = true;
				arr[idx] = arr[idx] + i;
				dfs(idx + 1, arr);
				arr[idx] = arr[idx] - i;
				cctvDirect[idx][i] = false;
			}
		}
	}

	static int findNum(int[][] map, int[] dir) { // 사각지대 개수구함
		for (int i = 0; i < cctv.size(); i++) {
			int[] cctvXY = cctv.get(i);
			int x = cctvXY[0];
			int y = cctvXY[1];
			int d = dir[i];
			
			int len = cctvMap.get(map[x][y])[d].length/2;
			for (int j = 0; j < len; j++) {
				int nx = x;
				int ny = y;
				int dx = cctvMap.get(map[x][y])[d][j*2];
				int dy = cctvMap.get(map[x][y])[d][j*2 + 1];

				while (true) {
					nx += dx;
					ny += dy;
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny]!=6) {
						if(map[nx][ny]==0) {
							map[nx][ny] = 7;	
						}
					} else {
						break;
					}
				}
				

			}

		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j]==0)
					cnt++;
			}
		}
		return cnt;
	}

	static int[][] deepCopy(int[][] arr) {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}
}