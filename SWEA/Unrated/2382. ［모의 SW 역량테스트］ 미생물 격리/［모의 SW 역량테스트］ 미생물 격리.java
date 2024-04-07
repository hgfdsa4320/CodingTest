import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class MSM {
	int x;
	int y;
	int num;
	int d;

	public MSM(int x, int y, int num, int d) {
		this.x = x;
		this.y = y;
		this.num = num;
		this.d = d;
	}

	public String toString() {
		return x + " " + y + " " + num + " " + d;
	}
}

public class Solution {
	static int N, M, K;
	static int[] dx = {0, -1, 1, 0, 0,};
	static int[] dy = {0, 0, 0, -1, 1};
	static Queue<MSM> q;
	static List<MSM>[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			q = new LinkedList<>();
			map = new ArrayList[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				MSM msm = new MSM(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				q.offer(msm);
				map[msm.x][msm.y].add(msm);
			}

			while (M > 0) {
				Set<String> set = new HashSet<>();
				while (!q.isEmpty()) {
					MSM m = q.poll();
					map[m.x][m.y].remove(m);
					int nx = m.x + dx[m.d];
					int ny = m.y + dy[m.d];
					//약품이 칠해진 구역
					if (nx <= 0 || nx >= N - 1 || ny <= 0 || ny >= N - 1) {
						m.d = m.d % 2 == 0 ? m.d - 1 : m.d + 1;
						m.num /= 2;
					}
					m.x = nx;
					m.y = ny;
					map[m.x][m.y].add(m);
					set.add(m.x + " "+m.y);
				}
				for (String tmp : set) {
					int x = Integer.parseInt(tmp.split(" ")[0]);
					int y = Integer.parseInt(tmp.split(" ")[1]);
					if (map[x][y].size() == 1) {
						q.offer(map[x][y].get(0));
					} else {
						List<MSM> list = map[x][y];
						map[x][y] = new ArrayList<>();
						int total = 0;
						int[] max = new int[2];
						for (int i = 0; i < list.size(); i++) {
							MSM msm = list.get(i);
							if (msm.num > max[1]) {
								max[0] = msm.d;
								max[1] = msm.num;
							}
							total += msm.num;
						}
						q.offer(new MSM(x, y, total, max[0]));
					}
				}
				M--;
			}
			int cnt = 0;
			while (!q.isEmpty()) {
				cnt += q.poll().num;
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}