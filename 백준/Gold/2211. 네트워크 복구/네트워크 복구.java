import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최소한의 회선 + 최소한의 비용
 * 다익스트라
 * int[] distance를 시작 번호(1)을 제외하고 Integer.MAX_VALUE로 초기화
 * 방문 안한 지점 중 현재까지의 비용+ 현재에서 가는 비용 < distance[목표 지점] 일 경우 바꿔주기 -> 이렇게 하면 최소 비용은 알 수 있는데
 *
 * 4 5
 * 1 2 1
 * 1 4 4
 * 1 3 2
 * 4 2 2
 * 4 3 3
 *
 * 1 2 3 4
 * 0 1 2 3
 * 	 1 1 2
 * distance[][]를 이차월 배열로 만들어서 전에 어디서 왔는지 확인 {거리, 이전 장소}
 * 이후 유니온파인드
 */
public class Main {
	static int[] parent;
	static int[][] distance;
	static boolean[] visited;
	static List<int[]>[] arr;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		distance = new int[N + 1][2];
		visited = new boolean[N + 1];
		arr = new ArrayList[N+1];
		for (int i = 2; i <= N; i++) {
			distance[i][0] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new int[] {b, c});
			arr[b].add(new int[] {a, c});
		}
		// 다익스트라로 최단거리 + 전에 어디서 왔는지 확인
		dijkstra(1);
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 2; i <= N; i++) {
			//현재랑 이전 회선과 연결되지 않은 경우
			if (union(i, distance[i][1])) {
				count++;
				sb.append(i + " " + distance[i][1]).append("\n");
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return false;
		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
		return true;
	}

	static int find(int a) {
		if(a==parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	static void dijkstra(int num) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] {num, 0});

		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			int now = p[0];
			if(visited[now]) continue;
			visited[now] = true;
			int nowCost = p[1];
			for (int i = 0; i < arr[now].size(); i++) {
				int next = arr[now].get(i)[0];
				int nextCost = arr[now].get(i)[1];
				if (nowCost + nextCost < distance[next][0]) {
					distance[next][0] = nowCost + nextCost;
					distance[next][1] = now;
					pq.offer(new int[] {next, nowCost + nextCost});
				}
			}
		}
	}
}